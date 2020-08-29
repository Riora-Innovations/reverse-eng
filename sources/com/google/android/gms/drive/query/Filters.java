package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.f847Ff, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.f847Ff, filters);
    }

    public static Filter contains(MetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.f850Fi, field, value);
    }

    /* renamed from: eq */
    public static <T> Filter m953eq(MetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f842Fa, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(OrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f845Fd, (MetadataField<T>) field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(OrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f846Fe, (MetadataField<T>) field, value);
    }

    /* renamed from: in */
    public static <T> Filter m954in(CollectionMetadataField<T> field, T value) {
        return new InFilter(field, value);
    }

    public static <T extends Comparable<T>> Filter lessThan(OrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f843Fb, (MetadataField<T>) field, value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(OrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f844Fc, (MetadataField<T>) field, value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    /* renamed from: or */
    public static Filter m955or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.f848Fg, filter, additionalFilters);
    }

    /* renamed from: or */
    public static Filter m956or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.f848Fg, filters);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.f818EH);
    }
}
