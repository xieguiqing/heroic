package com.spotify.heroic.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "OPERATOR", "tag" }, doNotUseGetters = true)
public class HasTagFilter implements OneTermFilter {
    public static final String OPERATOR = "+";

    public static final OneTermFilterBuilder<HasTagFilter> BUILDER = new OneTermFilterBuilder<HasTagFilter>() {
        @Override
        public HasTagFilter build(String first) {
            return new HasTagFilter(first);
        }
    };

    private final String tag;

    @Override
    public String toString() {
        return "[" + OPERATOR + ", " + tag + "]";
    }

    @Override
    public HasTagFilter optimize() {
        return this;
    }

    @Override
    public String operator() {
        return OPERATOR;
    }

    @Override
    public String first() {
        return tag;
    }
}