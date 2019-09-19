package eu.lidovydum.riddle4j.lib;

import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

class Reflection<T extends Situation> {

    private static Reflections reflections = new Reflections("eu.lidovydum.riddle4j");

    Set<Rule> getRules() {
        Set<Class<? extends Rule>> ruleClasses = reflections.getSubTypesOf(Rule.class);
        Set<Rule> rules = new HashSet<Rule>();
        for (Class<? extends Rule> ruleClass : ruleClasses) {
            try {
                rules.add(ruleClass.newInstance());
            } catch (InstantiationException ignored) {
            } catch (IllegalAccessException ignored) {
            }
        }
        return rules;
    }

    Set<Move> getMoves() {
        Set<Class<? extends Move>> moveClasses = reflections.getSubTypesOf(Move.class);
        Set<Move> moves = new HashSet<Move>();
        for (Class<? extends Move> moveClass : moveClasses) {
            try {
                moves.add(moveClass.newInstance());
            } catch (InstantiationException ignored) {
            } catch (IllegalAccessException ignored) {
            }
        }
        return moves;
    }
}