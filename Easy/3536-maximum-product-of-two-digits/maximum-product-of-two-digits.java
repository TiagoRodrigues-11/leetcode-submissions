class Solution {
    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();
        
        while (n >= 10) {
            int digit = n % 10;
            digits.add(digit);
            n = n / 10;
        }
        
        digits.add(n);
        
        int maxProduct = -Integer.MAX_VALUE;
        
        for (int i = 0; i < digits.size(); i++) {
            for (int j = 0; j < digits.size(); j++) {
                if (i != j) {
                    maxProduct = Math.max(maxProduct, digits.get(i)*digits.get(j));
                }
            }
        }
        
        return maxProduct;
    }
}