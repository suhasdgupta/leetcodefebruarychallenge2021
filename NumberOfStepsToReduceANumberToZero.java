class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps (int num) {
        if (num == 0) return 0;
        int result = 0;
        
        while (num != 0) {    
            // In order to count steps when right shifting one digit 
            // For odd: we will subtract and divide by 2, which takes 2 steps 
            // For even: we just divide by 2, which takes 1 step
            result += ((num & 1) == 0 ? 1 : 2);
            num >>= 1;
        }
        // We subtract 1 from result because when we get to the most significant 1, 
        // we only need to subtract it and we no longer need to divide by 2, so 
        // only 1 step needed instead of the 2 that we counted when using the above while loop
        return result - 1;
    }
}
