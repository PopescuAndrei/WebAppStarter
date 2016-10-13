package ro.andrei.webapp.util;

import com.google.common.collect.Ordering;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.joining;

/**
 * Created by epopean on 10/12/2016.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException("Should not be instantiated");
    }

    /**
     * Method that checks if all the provided {@code arguments} are null.
     *
     * @param arguments
     * @return
     */
    public static boolean areNulls(Object... arguments) {
        int nulls = 0;
        for (Object item : arguments) {
            if (item == null) {
                nulls++;
            }
        }
        return nulls == arguments.length;
    }


    /**
     * Method that generates a repeated comma separated string.
     *
     * @param str
     * 			the string that is repeated
     * @param count
     * 			the number of times the string is repeated
     * @return
     */
    public static String repeatCsv(String str, int count) {
        return Stream.generate(() -> str)
                .limit(count)
                .collect(joining(","));
    }

    /**
     * Method that concatenates the provided {@code elements},
     * separated by the provided {@code separator}.
     *
     * @param separator
     * @param elements
     * @return
     */
    public static String join(String separator, String... elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Invalid elements parameter.");
        }
        return Arrays.stream(elements)
                .collect(joining(separator));
    }

    /**
     * Method that provides the last character of the provided {@code str}
     * or {@code null} in case the provided {@code str} is {@code null).
     *
     * @param str
     * @return
     */
    public static String lastChar(String str) {
        if (str == null ||
                str.length() == 0) {
            return null;
        }
        return str.substring(str.length()-1);
    }

    /**
     * Removes all duplicate elements from a list.
     *
     * @param list
     * @return
     */
    public static <T> List<T> distinct(List<T> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Removes all duplicate elements from a list and sort these using comparator.
     *
     * @param list
     * @return
     */
    public static <T> List<T> distinct(List<T> list, Comparator<? super T> comparator) {
        return list.stream()
                .distinct()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Method that creates a list of {@link Object}s
     * having as input the provided {@code items}.
     * <p>
     * In case an item is of type {@link List},
     * all its items are added to the result.
     *
     * @param items
     * @return
     */
    public static List<Object> asList(Object... items) {
        List<Object> result = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof Collection<?>) {
                result.addAll((Collection<?>)item);
            } else {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Method that creates an array of of {@link Object}s
     * having as input the provided {@code items}.
     * <p>
     * In case an item is of type {@link List},
     * all its items are added to the result.
     *
     * @param items
     * @return
     *
     * @see #asList(Object...)
     */
    public static Object[] toArray(Object... items) {
        return asList(items).stream()
                .toArray(Object[]::new);
    }

    /**
     * Method that truncates the provided {@code value} at the provided
     * {@code threshold}.
     * <p>
     * If {@code value} is outside the interval [-threshold ; threshold],
     * {@code -threshold} or {@code threshold} is returned depending if the
     * {@code value} is positive or not, otherwise the {@code value} is returned.
     *
     * @param value
     * @param threshold
     * @return
     */
    public static Double truncate(Double value, double threshold) {
        checkArgument(threshold > 0);

        if (value == null ||
                (value >= -1 * threshold && value <= threshold)) {
            return value;
        }
        return value < 0 ? (-1 * threshold) : threshold;
    }

    /**
     * Method that converts a {@link Collection} of {@link Long}
     * ids to an array of corresponding primitives.
     * <p>
     * Filtering of null values is applied.
     *
     * @param ids
     * @return
     */
    public static long[] toLongArray(Collection<Long> ids) {
        return ids.stream()
                .filter(id -> !Objects.isNull(id))
                .mapToLong(id -> id)
                .toArray();
    }

    /**
     * Method that checks whether the provided list of comparable elements
     * is ordered in ascending order.
     *
     * @param list
     * @return
     */
    public static <T extends Comparable<T>> boolean isOrderedAsc(Collection<T> list) {
        return Ordering.natural().isOrdered(list);
    }

    /**
     * Method that checks whether the provided list of comparable elements
     * is ordered in descending order.
     *
     * @param list
     * @return
     */
    public static <T extends Comparable<T>> boolean isOrderedDesc(Collection<T> list) {
        return Ordering.natural().reverse().isOrdered(list);
    }

    /**
     * Method that checks whether the Double elements in the provided list
     * are all of percentage type.
     *
     * @param collection
     * @return
     */
    public static boolean isPercentage(Collection<Double> collection) {
        return collection.stream()
                .filter(el -> el != null)
                .allMatch(el -> (el >= 0 && el <= 100));
    }

    /**
     * Method that formats the home page of the user
     * so that it is in the expected form.
     *
     * @param url
     *
     * @return
     * 		the provided {@code url}, in case it is null
     * 		or a trimmed string prefixed by a slash ('/')
     */
    public static String formatHomePageUrl(String url) {
        if (url == null ||
                url.trim().length() == 0) {
            return url;
        }
        url = url.trim();
        return url.startsWith("/") ? url : "/" + url;
    }
}