class RomanToInteger {
    public int romanToInt(String romanNum) {
        if (romanNum == null || romanNum.isEmpty()) {
			return 0;
		}

		int[] nums = new int[romanNum.length()];

		for (int i = 0; i < romanNum.length(); i++) {
			switch (romanNum.charAt(i)) {
			case 'I':
				nums[i] = 1;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'M':
				nums[i] = 1000;
				break;
			default:
				break;
			}
		}

		int sum = 0;

		for (int i = 0; i < romanNum.length()-1; i++) {
			if (nums[i] < nums[i + 1]) {
				sum -= nums[i];
			} else {
				sum += nums[i];
			}
		}
		return sum + nums[romanNum.length() - 1];
    }
}
