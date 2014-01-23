int getDec(int i) {
    def dec = 10
    def num = 1
    while (num != 0) {
        num = i - (i % dec)
        if (num != 0) {
            dec = dec * 10
        }
    }
    dec = dec / 10
}

def reverse(int i) {
    def dec = getDec(i)
    def num = 0
    def org = i
    while (org != 0) {
        def mod = (org % 10)
        num = num + (mod * dec) // <- overflow possibility?
        dec = dec / 10
        org = (int) (org - mod) / 10
    }
    num
}

def isPalindrome(int num) {
    return num == reverse(num)
}

// Version 2

// consider the possibility that the reversed number might overflow
def reverseV2(int num) {
    def rev = 0
    while (num != 0) {
        rev = rev * 10 + num % 10;
        num /= 10
    }
    rev
}


def isPalindromeV2(int num) {
    return num == reverseV2(num)
}

assert 12321 == reverse(12321)
assert 11 == reverse(11)
assert 121 == reverse(121)
assert 12221 == reverse(12221)
assert 123 != reverse(123)
assert isPalindrome(12321)
assert isPalindrome(11)
assert isPalindrome(121)
assert isPalindrome(1)
assert !isPalindrome(123)
assert isPalindrome(123454321)

assert 12321 == reverseV2(12321)
assert 11 == reverseV2(11)
assert 121 == reverseV2(121)
assert 12221 == reverseV2(12221)
assert 123 != reverseV2(123)
assert isPalindromeV2(12321)
assert isPalindromeV2(11)
assert isPalindromeV2(121)
assert isPalindromeV2(1)
assert !isPalindromeV2(123)
assert isPalindromeV2(123454321)