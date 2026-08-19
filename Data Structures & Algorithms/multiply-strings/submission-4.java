class Solution {
    StringBuffer getSum(StringBuffer prod, StringBuffer sum) {
        if(prod.length() == 0)
            return sum;
        
        int n = prod.length();
        int m = sum.length();
        int carry = 0;
        int i = n-1, j = m-1;

        StringBuffer summation = new StringBuffer("");
        while(i >= 0 && j >= 0) {
            int d1 = prod.charAt(i) - '0';
            int d2 = sum.charAt(j) - '0';

            int val = d1 + d2 + carry;
            carry = val > 9 ? 1 : 0;
            val = val%10;

            summation.append(String.valueOf(val));
            i--;
            j--;
        }

        while(i >= 0) {
            int d1 = prod.charAt(i) - '0';
            int val = d1 + carry;
            carry = val > 9 ? 1 : 0;
            val = val % 10;

            summation.append(String.valueOf(val));
            i--;
        }

        while(j >= 0) {
            int d1 = sum.charAt(j) - '0';
            int val = d1 + carry;
            carry = val > 9 ? 1 : 0;
            val = val % 10;

            summation.append(String.valueOf(val));
            j--;
        }

        if(carry > 0)
            summation.append(String.valueOf(carry));

        return summation.reverse();
    }

    public String multiply(String num1, String num2) {
        if(num2.length() < num1.length())
            return multiply(num2, num1);
        
        String rev1 = new StringBuffer(num1).reverse().toString();
        String rev2 = new StringBuffer(num2).reverse().toString();
        StringBuffer product = new StringBuffer("");

        for(int i=0;i<rev1.length();i++) {
            StringBuffer sum = new StringBuffer("");
            int dig1 = rev1.charAt(i) - '0';
            if(dig1 == 0)
                continue;
            int carry = 0;

            for(int j=0;j<i;j++) {
                sum.append("0");
            }

            for(int j=0;j<rev2.length();j++) {
                int dig2 = rev2.charAt(j) - '0';
                int prod = (dig1 * dig2) + carry;
                int val = prod % 10;
                carry = prod / 10;

                sum.append(String.valueOf(val));
            }
            if(carry > 0)
                sum.append(String.valueOf(carry));

            sum.reverse();
            // System.out.println("sum: " + sum);
            // System.out.println("product: " + product);
            product = getSum(product, sum);
            // System.out.println("new-product: " + product);
        }

        if(product.isEmpty())
            return "0";
        
        return product.toString();
    }
}
