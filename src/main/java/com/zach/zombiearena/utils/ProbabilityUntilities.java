package com.zach.zombiearena.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProbabilityUntilities {
    private final List<Chance> chances;
    private final Random random;
    private int sum;
    public ProbabilityUntilities() {
        this.random = new Random();
        this.chances = new ArrayList<>();
        this.sum = 0;
    }

    public void clearChances() {
        chances.clear();
        this.sum = 0;
    }

    public ProbabilityUntilities(long seed) {
        this.random = new Random(seed);
        this.chances = new ArrayList<>();
        this.sum = 0;
    }
    public void addChance(Object element, int chance) {
        if (!this.chances.contains(element)) {
            this.chances.add(new Chance(element, this.sum, this.sum + chance));
            this.sum = this.sum + chance;
        } else {
            // not sure yet, what to do, when the element already exists, since a list can't contain 2 equal entries.
            // Right now a second, identical chance (element + chance must be equal) will be ignored
        }
    }

    public Object getRandomElement() {
        int index = this.random.nextInt(this.sum);
        //System.out.println("Amount of chances: " + Integer.toString(this.chances.size()) + ", possible options: "
        //+ Integer.toString(this.sum) + ", chosen option: " + Integer.toString(index));
        for (Chance chance : this.chances) {
            //System.out.println(chance.toString());
            if (chance.getLowerLimit() <= index && chance.getUpperLimit() > index) {
                return chance.getElement();
            }
        }
        return null; // this should never happen, because the random can't be out of the limits
    }

    public int getOptions() { // might be needed sometimes
        return this.sum;
    }

    public int getChoices() { // might be needed sometimes
        return this.chances.size();
    }

    private class Chance {
        private final int upperLimit;
        private final int lowerLimit;
        private final Object element;

        public Chance(Object element, int lowerLimit, int upperLimit) {
            this.element = element;
            this.upperLimit = upperLimit;
            this.lowerLimit = lowerLimit;
        }

        public int getUpperLimit() {
            return this.upperLimit;
        }

        public int getLowerLimit() {
            return this.lowerLimit;
        }

        public Object getElement() {
            return this.element;
        }

        public String toString() {
            return "[" + this.lowerLimit + "|" + this.upperLimit + "]: " + this.element.toString();
        }
    }
}
