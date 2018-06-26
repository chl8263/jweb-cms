package io.sited.redis.impl;

import com.google.common.collect.ImmutableMap;
import io.sited.cache.Cache;
import io.sited.cache.CacheOptions;
import io.sited.cache.CacheVendor;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author chi
 */
public class NoneCacheVendor implements CacheVendor {
    @Override
    public <T> Cache<T> create(Type type, String cacheName, CacheOptions options) {
        return new NodeCache<>();
    }

    static class NodeCache<T> implements Cache<T> {
        @Override
        public Optional<T> get(String key) {
            return Optional.empty();
        }

        @Override
        public Map<String, T> batchGet(List<String> keys) {
            return ImmutableMap.of();
        }

        @Override
        public void put(String key, T value) {
        }

        @Override
        public void batchPut(Map<String, T> values) {
        }

        @Override
        public void delete(String key) {
        }

        @Override
        public void batchDelete(List<String> keys) {
        }
    }
}
