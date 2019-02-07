package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        constructorConstructor = constructorConstructor.get(TypeToken.get(jsonAdapter.value())).construct();
        if ((constructorConstructor instanceof TypeAdapter) != null) {
            constructorConstructor = (TypeAdapter) constructorConstructor;
        } else if ((constructorConstructor instanceof TypeAdapterFactory) != null) {
            constructorConstructor = ((TypeAdapterFactory) constructorConstructor).create(gson, typeToken);
        } else {
            jsonAdapter = constructorConstructor instanceof JsonSerializer;
            if (jsonAdapter == null) {
                if (!(constructorConstructor instanceof JsonDeserializer)) {
                    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
                }
            }
            JsonDeserializer jsonDeserializer = null;
            JsonSerializer jsonSerializer = jsonAdapter != null ? (JsonSerializer) constructorConstructor : null;
            if ((constructorConstructor instanceof JsonDeserializer) != null) {
                jsonDeserializer = (JsonDeserializer) constructorConstructor;
            }
            ConstructorConstructor treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null);
        }
        return constructorConstructor != null ? constructorConstructor.nullSafe() : constructorConstructor;
    }
}
