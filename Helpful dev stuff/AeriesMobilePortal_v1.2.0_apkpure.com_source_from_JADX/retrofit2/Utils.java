package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;

final class Utils {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = type;
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || Utils.equals(this, (GenericArrayType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Utils.typeToString(this.componentType));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
            int i;
            int i2 = 0;
            if (type2 instanceof Class) {
                i = 1;
                int i3 = type == null ? 1 : 0;
                if (((Class) type2).getEnclosingClass() != null) {
                    i = 0;
                }
                if (i3 != i) {
                    throw new IllegalArgumentException();
                }
            }
            i = typeArr.length;
            while (i2 < i) {
                Type type3 = typeArr[i2];
                Utils.checkNotNull(type3, "typeArgument == null");
                Utils.checkNotPrimitive(type3);
                i2++;
            }
            this.ownerType = type;
            this.rawType = type2;
            this.typeArguments = (Type[]) typeArr.clone();
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getRawType() {
            return this.rawType;
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || Utils.equals(this, (ParameterizedType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ (this.ownerType != null ? this.ownerType.hashCode() : 0);
        }

        public String toString() {
            if (this.typeArguments.length == 0) {
                return Utils.typeToString(this.rawType);
            }
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder(30 * (this.typeArguments.length + 1));
            stringBuilder.append(Utils.typeToString(this.rawType));
            stringBuilder.append("<");
            stringBuilder.append(Utils.typeToString(this.typeArguments[0]));
            while (i < this.typeArguments.length) {
                stringBuilder.append(", ");
                stringBuilder.append(Utils.typeToString(this.typeArguments[i]));
                i++;
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] != null) {
                    Utils.checkNotPrimitive(typeArr2[0]);
                    if (typeArr[0] == Object.class) {
                        this.lowerBound = typeArr2[0];
                        this.upperBound = Object.class;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw new NullPointerException();
            } else if (typeArr[0] != null) {
                Utils.checkNotPrimitive(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = typeArr[0];
            } else {
                throw new NullPointerException();
            }
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public Type[] getLowerBounds() {
            if (this.lowerBound == null) {
                return Utils.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{this.lowerBound};
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || Utils.equals(this, (WildcardType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return (this.lowerBound != null ? this.lowerBound.hashCode() + 31 : 1) ^ (31 + this.upperBound.hashCode());
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.lowerBound != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                stringBuilder.append(Utils.typeToString(this.lowerBound));
                return stringBuilder.toString();
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? extends ");
                stringBuilder.append(Utils.typeToString(this.upperBound));
                return stringBuilder.toString();
            }
        }
    }

    private Utils() {
    }

    static Class<?> getRawType(Type type) {
        checkNotNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
            if (type instanceof Class) {
                return (Class) type;
            }
            throw new IllegalArgumentException();
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            stringBuilder.append(type);
            stringBuilder.append("> is of type ");
            stringBuilder.append(type.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    static boolean equals(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if ((ownerType != ownerType2 && (ownerType == null || !ownerType.equals(ownerType2))) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()) == null) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()) == null) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || typeVariable.getName().equals(typeVariable2.getName()) == null) {
                z = false;
            }
            return z;
        }
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface() != null) {
            type = cls.getInterfaces();
            int length = type.length;
            for (int i = 0; i < length; i++) {
                if (type[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(type[i])) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], type[i], cls2);
                }
            }
        }
        if (cls.isInterface() == null) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return resolve(type, cls, getGenericSupertype(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static Type resolve(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            type2 = (TypeVariable) type2;
            Type resolveTypeVariable = resolveTypeVariable(type, cls, type2);
            if (resolveTypeVariable == type2) {
                return resolveTypeVariable;
            }
            type2 = resolveTypeVariable;
        }
        if (type2 instanceof Class) {
            resolveTypeVariable = (Class) type2;
            if (resolveTypeVariable.isArray()) {
                type2 = resolveTypeVariable.getComponentType();
                type = resolve(type, cls, type2);
                if (type2 != type) {
                    resolveTypeVariable = new GenericArrayTypeImpl(type);
                }
                return resolveTypeVariable;
            }
        }
        if (type2 instanceof GenericArrayType) {
            type2 = (GenericArrayType) type2;
            resolveTypeVariable = type2.getGenericComponentType();
            type = resolve(type, cls, resolveTypeVariable);
            if (resolveTypeVariable != type) {
                type2 = new GenericArrayTypeImpl(type);
            }
            return type2;
        }
        int i = 0;
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            resolveTypeVariable = parameterizedType.getOwnerType();
            Type resolve = resolve(type, cls, resolveTypeVariable);
            int i2 = resolve != resolveTypeVariable ? 1 : 0;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type resolve2 = resolve(type, cls, actualTypeArguments[i]);
                if (resolve2 != actualTypeArguments[i]) {
                    if (i2 == 0) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        i2 = 1;
                    }
                    actualTypeArguments[i] = resolve2;
                }
                i++;
            }
            return i2 != 0 ? new ParameterizedTypeImpl(resolve, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        } else if (!(type2 instanceof WildcardType)) {
            return type2;
        } else {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                if (resolve(type, cls, lowerBounds[0]) != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{resolve(type, cls, lowerBounds[0])});
                }
            } else if (upperBounds.length == 1 && resolve(type, cls, upperBounds[0]) != upperBounds[0]) {
                return new WildcardTypeImpl(new Type[]{resolve(type, cls, upperBounds[0])}, EMPTY_TYPE_ARRAY);
            }
            return wildcardType;
        }
    }

    private static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        type = getGenericSupertype(type, cls, declaringClassOf);
        if ((type instanceof ParameterizedType) == null) {
            return typeVariable;
        }
        return ((ParameterizedType) type).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        typeVariable = typeVariable.getGenericDeclaration();
        return typeVariable instanceof Class ? (Class) typeVariable : null;
    }

    static void checkNotPrimitive(Type type) {
        if (!(type instanceof Class)) {
            return;
        }
        if (((Class) type).isPrimitive() != null) {
            throw new IllegalArgumentException();
        }
    }

    static <T> T checkNotNull(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static boolean isAnnotationPresent(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Object isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return 1;
            }
        }
        return false;
    }

    static ResponseBody buffer(ResponseBody responseBody) throws IOException {
        Object buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    static <T> void validateServiceInterface(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > null) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index ");
            stringBuilder.append(i);
            stringBuilder.append(" not in range [0,");
            stringBuilder.append(actualTypeArguments.length);
            stringBuilder.append(") for ");
            stringBuilder.append(parameterizedType);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        i = actualTypeArguments[i];
        return (i instanceof WildcardType) != null ? ((WildcardType) i).getUpperBounds()[null] : i;
    }

    static boolean hasUnresolvableType(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type hasUnresolvableType : ((ParameterizedType) type).getActualTypeArguments()) {
                if (hasUnresolvableType(hasUnresolvableType)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return hasUnresolvableType(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            String str;
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            stringBuilder.append(type);
            stringBuilder.append("> is of type ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    static Type getCallResponseType(Type type) {
        if (type instanceof ParameterizedType) {
            return getParameterUpperBound(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static void throwIfFatal(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
