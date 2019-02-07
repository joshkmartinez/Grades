package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.Priority;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PicassoExecutorService extends ThreadPoolExecutor {
    private static final int DEFAULT_THREAD_COUNT = 3;

    private static final class PicassoFutureTask extends FutureTask<BitmapHunter> implements Comparable<PicassoFutureTask> {
        private final BitmapHunter hunter;

        PicassoFutureTask(BitmapHunter bitmapHunter) {
            super(bitmapHunter, null);
            this.hunter = bitmapHunter;
        }

        public int compareTo(PicassoFutureTask picassoFutureTask) {
            Priority priority = this.hunter.getPriority();
            Priority priority2 = picassoFutureTask.hunter.getPriority();
            return priority == priority2 ? this.hunter.sequence - picassoFutureTask.hunter.sequence : priority2.ordinal() - priority.ordinal();
        }
    }

    PicassoExecutorService() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new PicassoThreadFactory());
    }

    void adjustThreadCount(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.isConnectedOrConnecting()) {
                int type = networkInfo.getType();
                if (!(type == 6 || type == 9)) {
                    switch (type) {
                        case 0:
                            networkInfo = networkInfo.getSubtype();
                            switch (networkInfo) {
                                case 1:
                                case 2:
                                    setThreadCount(1);
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    setThreadCount(2);
                                    break;
                                default:
                                    switch (networkInfo) {
                                        case 12:
                                            break;
                                        case 13:
                                        case 14:
                                        case 15:
                                            setThreadCount(3);
                                            break;
                                        default:
                                            setThreadCount(3);
                                            break;
                                    }
                                    setThreadCount(2);
                                    break;
                            }
                        case 1:
                            break;
                        default:
                            setThreadCount(3);
                            break;
                    }
                }
                setThreadCount(4);
                return;
            }
        }
        setThreadCount(3);
    }

    private void setThreadCount(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        Object picassoFutureTask = new PicassoFutureTask((BitmapHunter) runnable);
        execute(picassoFutureTask);
        return picassoFutureTask;
    }
}
