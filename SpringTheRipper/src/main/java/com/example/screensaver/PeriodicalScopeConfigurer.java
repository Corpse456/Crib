package com.example.screensaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

public class PeriodicalScopeConfigurer implements Scope {

    private final Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(final String name, final ObjectFactory<?> objectFactory) {
        if (!map.containsKey(name) || moreThanFiveSecondsPast(name)) {
            map.put(name, new Pair<>(now(), objectFactory.getObject()));
        }
        return map.get(name).second();
    }

    @Override
    public Object remove(final String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(final String name, final Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(final String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

    private boolean moreThanFiveSecondsPast(final String name) {
        return Duration.between(map.get(name).first(), now()).getSeconds() > 5;
    }
}
