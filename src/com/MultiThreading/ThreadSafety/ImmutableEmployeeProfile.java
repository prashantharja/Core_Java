package com.MultiThreading.ThreadSafety;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. Class is 'final' so nobody can extend it and override methods to break it.
public final class ImmutableEmployeeProfile {

    // 2. Fields are 'private' and 'final'
    private final String name;
    private final List<String> skills; // WARNING: List is a mutable object!

    // 3. Set values ONCE via constructor
    public ImmutableEmployeeProfile(String name, List<String> skills) {
        this.name = name;
        
        // DEFENSIVE COPY IN:
        // If we just do 'this.skills = skills;', the caller could change the original 
        // list later, which would secretly change our "immutable" object!
        this.skills = new ArrayList<>(skills); 
    }

    // 4. No Setters provided.

    public String getName() {
        return name; // String is already immutable, safe to return directly
    }

    public List<String> getSkills() {
        // DEFENSIVE COPY OUT:
        // Never return the actual reference to our private list. 
        // Return a fresh copy (or an unmodifiable view) so threads can't alter our internal state.
        return Collections.unmodifiableList(this.skills);
        
        // Alternative: return new ArrayList<>(this.skills);
    }
}