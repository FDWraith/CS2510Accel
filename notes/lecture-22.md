### Lecture 22

```java
// finds the index of the needle in the haystack.
// returns -1 if not found
// NOTE: Assume haystack is sorted
int find(ArrayList<String> haystack, String needle) {
  return findHelp(haystack, needle, 0, haystack.size());
}

// finds the needle in the haystack in the range [start, end)
int findHelp(ArrayList<String> haystack, String needle, int start, int end) {
  int middle = (start + end) / 2;
  if (start >= end) {
    return -1;
  }
  if (haystack.get(middle).equals(needle)) { 
    return middle; 
  } else if (needle.compareTo(haystack.get(middle)) < 0) { 
    return findHelp(haystack, needle, start, middle));
  } else {
    return findHelp(haystack, needle, middle + 1, end);
  }
}


// Let's use a while loop
int find(ArrayList<String> haystack, String needle) {
  int start = 0;
  int end = haystack.size();
  while (start < end) {
    int middle = (start + end) / 2;
    if (haystack.get(middle).equals(needle)) {
      return middle;
    } else if (needle.compareTo(haystack.get(middle)) < 0) {
      end = middle;
    } else {
      start = middle + 1;
    }
  }
  return -1;
}
```

decorating a data structure allows you to cache information that can be useful to solve a problem.