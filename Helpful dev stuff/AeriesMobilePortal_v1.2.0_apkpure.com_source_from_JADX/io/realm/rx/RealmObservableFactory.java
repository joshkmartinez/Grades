package io.realm.rx;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import java.util.IdentityHashMap;
import java.util.Map;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class RealmObservableFactory implements RxObservableFactory {
    ThreadLocal<StrongReferenceCounter<RealmList>> listRefs = new C10012();
    ThreadLocal<StrongReferenceCounter<RealmModel>> objectRefs = new C10023();
    ThreadLocal<StrongReferenceCounter<RealmResults>> resultsRefs = new C10001();

    class C10001 extends ThreadLocal<StrongReferenceCounter<RealmResults>> {
        C10001() {
        }

        protected StrongReferenceCounter<RealmResults> initialValue() {
            return new StrongReferenceCounter();
        }
    }

    class C10012 extends ThreadLocal<StrongReferenceCounter<RealmList>> {
        C10012() {
        }

        protected StrongReferenceCounter<RealmList> initialValue() {
            return new StrongReferenceCounter();
        }
    }

    class C10023 extends ThreadLocal<StrongReferenceCounter<RealmModel>> {
        C10023() {
        }

        protected StrongReferenceCounter<RealmModel> initialValue() {
            return new StrongReferenceCounter();
        }
    }

    private static class StrongReferenceCounter<K> {
        private final Map<K, Integer> references;

        private StrongReferenceCounter() {
            this.references = new IdentityHashMap();
        }

        public void acquireReference(K k) {
            Integer num = (Integer) this.references.get(k);
            if (num == null) {
                this.references.put(k, Integer.valueOf(1));
            } else {
                this.references.put(k, Integer.valueOf(num.intValue() + 1));
            }
        }

        public void releaseReference(K k) {
            Integer num = (Integer) this.references.get(k);
            StringBuilder stringBuilder;
            if (num == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Object does not have any references: ");
                stringBuilder.append(k);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (num.intValue() > 1) {
                this.references.put(k, Integer.valueOf(num.intValue() - 1));
            } else if (num.intValue() == 1) {
                this.references.remove(k);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid reference count: ");
                stringBuilder.append(num);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    public int hashCode() {
        return 37;
    }

    public Observable<Realm> from(Realm realm) {
        realm = realm.getConfiguration();
        return Observable.create(new OnSubscribe<Realm>() {
            public void call(final Subscriber<? super Realm> subscriber) {
                final Realm instance = Realm.getInstance(realm);
                final RealmChangeListener c10481 = new RealmChangeListener<Realm>() {
                    public void onChange(Realm realm) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(instance);
                        }
                    }
                };
                instance.addChangeListener(c10481);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        instance.removeChangeListener(c10481);
                        instance.close();
                    }
                }));
                subscriber.onNext(instance);
            }
        });
    }

    public Observable<DynamicRealm> from(DynamicRealm dynamicRealm) {
        dynamicRealm = dynamicRealm.getConfiguration();
        return Observable.create(new OnSubscribe<DynamicRealm>() {
            public void call(final Subscriber<? super DynamicRealm> subscriber) {
                final DynamicRealm instance = DynamicRealm.getInstance(dynamicRealm);
                final RealmChangeListener c10491 = new RealmChangeListener<DynamicRealm>() {
                    public void onChange(DynamicRealm dynamicRealm) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(instance);
                        }
                    }
                };
                instance.addChangeListener(c10491);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        instance.removeChangeListener(c10491);
                        instance.close();
                    }
                }));
                subscriber.onNext(instance);
            }
        });
    }

    public <E extends RealmModel> Observable<RealmResults<E>> from(Realm realm, final RealmResults<E> realmResults) {
        realm = realm.getConfiguration();
        return Observable.create(new OnSubscribe<RealmResults<E>>() {
            public void call(final Subscriber<? super RealmResults<E>> subscriber) {
                final Realm instance = Realm.getInstance(realm);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final RealmChangeListener c10501 = new RealmChangeListener<RealmResults<E>>() {
                    public void onChange(RealmResults<E> realmResults) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(realmResults);
                        }
                    }
                };
                realmResults.addChangeListener(c10501);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        realmResults.removeChangeListener(c10501);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                subscriber.onNext(realmResults);
            }
        });
    }

    public Observable<RealmResults<DynamicRealmObject>> from(DynamicRealm dynamicRealm, final RealmResults<DynamicRealmObject> realmResults) {
        dynamicRealm = dynamicRealm.getConfiguration();
        return Observable.create(new OnSubscribe<RealmResults<DynamicRealmObject>>() {
            public void call(final Subscriber<? super RealmResults<DynamicRealmObject>> subscriber) {
                final DynamicRealm instance = DynamicRealm.getInstance(dynamicRealm);
                ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).acquireReference(realmResults);
                final RealmChangeListener c10511 = new RealmChangeListener<RealmResults<DynamicRealmObject>>() {
                    public void onChange(RealmResults<DynamicRealmObject> realmResults) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(realmResults);
                        }
                    }
                };
                realmResults.addChangeListener(c10511);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        realmResults.removeChangeListener(c10511);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.resultsRefs.get()).releaseReference(realmResults);
                    }
                }));
                subscriber.onNext(realmResults);
            }
        });
    }

    public <E extends RealmModel> Observable<RealmList<E>> from(Realm realm, final RealmList<E> realmList) {
        realm = realm.getConfiguration();
        return Observable.create(new OnSubscribe<RealmList<E>>() {
            public void call(final Subscriber<? super RealmList<E>> subscriber) {
                final Realm instance = Realm.getInstance(realm);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final RealmChangeListener c10521 = new RealmChangeListener<RealmList<E>>() {
                    public void onChange(RealmList<E> realmList) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(realmList);
                        }
                    }
                };
                realmList.addChangeListener(c10521);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        realmList.removeChangeListener(c10521);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                subscriber.onNext(realmList);
            }
        });
    }

    public Observable<RealmList<DynamicRealmObject>> from(DynamicRealm dynamicRealm, final RealmList<DynamicRealmObject> realmList) {
        dynamicRealm = dynamicRealm.getConfiguration();
        return Observable.create(new OnSubscribe<RealmList<DynamicRealmObject>>() {
            public void call(final Subscriber<? super RealmList<DynamicRealmObject>> subscriber) {
                final DynamicRealm instance = DynamicRealm.getInstance(dynamicRealm);
                ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).acquireReference(realmList);
                final RealmChangeListener c10531 = new RealmChangeListener<RealmList<DynamicRealmObject>>() {
                    public void onChange(RealmList<DynamicRealmObject> realmList) {
                        if (subscriber.isUnsubscribed() == null) {
                            subscriber.onNext(realmList);
                        }
                    }
                };
                realmList.addChangeListener(c10531);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        realmList.removeChangeListener(c10531);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.listRefs.get()).releaseReference(realmList);
                    }
                }));
                subscriber.onNext(realmList);
            }
        });
    }

    public <E extends RealmModel> Observable<E> from(Realm realm, final E e) {
        realm = realm.getConfiguration();
        return Observable.create(new OnSubscribe<E>() {
            public void call(final Subscriber<? super E> subscriber) {
                final Realm instance = Realm.getInstance(realm);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(e);
                final RealmChangeListener c10461 = new RealmChangeListener<E>() {
                    public void onChange(E e) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(e);
                        }
                    }
                };
                RealmObject.addChangeListener(e, c10461);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        RealmObject.removeChangeListener(e, c10461);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(e);
                    }
                }));
                subscriber.onNext(e);
            }
        });
    }

    public Observable<DynamicRealmObject> from(DynamicRealm dynamicRealm, final DynamicRealmObject dynamicRealmObject) {
        dynamicRealm = dynamicRealm.getConfiguration();
        return Observable.create(new OnSubscribe<DynamicRealmObject>() {
            public void call(final Subscriber<? super DynamicRealmObject> subscriber) {
                final DynamicRealm instance = DynamicRealm.getInstance(dynamicRealm);
                ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).acquireReference(dynamicRealmObject);
                final RealmChangeListener c10471 = new RealmChangeListener<DynamicRealmObject>() {
                    public void onChange(DynamicRealmObject dynamicRealmObject) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(dynamicRealmObject);
                        }
                    }
                };
                RealmObject.addChangeListener(dynamicRealmObject, c10471);
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        RealmObject.removeChangeListener(dynamicRealmObject, c10471);
                        instance.close();
                        ((StrongReferenceCounter) RealmObservableFactory.this.objectRefs.get()).releaseReference(dynamicRealmObject);
                    }
                }));
                subscriber.onNext(dynamicRealmObject);
            }
        });
    }

    public <E extends RealmModel> Observable<RealmQuery<E>> from(Realm realm, RealmQuery<E> realmQuery) {
        throw new RuntimeException("RealmQuery not supported yet.");
    }

    public Observable<RealmQuery<DynamicRealmObject>> from(DynamicRealm dynamicRealm, RealmQuery<DynamicRealmObject> realmQuery) {
        throw new RuntimeException("RealmQuery not supported yet.");
    }

    public boolean equals(Object obj) {
        return obj instanceof RealmObservableFactory;
    }
}
