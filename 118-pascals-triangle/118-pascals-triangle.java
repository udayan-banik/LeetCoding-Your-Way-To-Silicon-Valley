class Solution {
  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>(numRows);
    result.add(Collections.singletonList(1));
    if (numRows == 1) {
      return result;
    }

    for (int i = 1; i < numRows; i++) {
      int length = i + 1;
      List<Integer> row = new ArrayList<>(length);
      List<Integer> up = result.get(i - 1);
      row.add(1);
      for (int j = 1; j < length - 1; j++) {
        row.add(up.get(j) + up.get(j - 1));
      }

      row.add(1);
      result.add(row);
    }

    return result;
  }
}