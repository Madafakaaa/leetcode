package p158_ReadNCharactersGivenRead4II;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/2 14:28
 */
public class Solution {
    char[] tempBuff = new char[4]; // Will store the result from read4(char[] buf)
    int tempBuffSize = 0; // However, read4(char[] buff) can only return the # chars read, so we need to keep track of current size
    int tempBuffIndex = 0; // As well as an index to traverse the array

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int counter = 0; // We will perform a while loop from 0 to n

        while (counter < n) {
            if (tempBuffIndex < tempBuffSize) { // Read each char in tempBuff
                buf[counter++] = tempBuff[tempBuffIndex++]; // Copy the data from tempBuff into buf
            } else {
                tempBuffSize = read4(tempBuff); // tempBuffSize AND tempBuff are updated in this line
                tempBuffIndex = 0; // Reset the counter to zero so we can iterate over tempBuff again

                if (tempBuffSize == 0) {
                    break; // End of file has been reached, no need to continue.
                }
            }
        }

        return counter; // At this point we have filled up buf and can return the number of chars read
    }

    public int read4(char[] tempBuff) {
        return 0;
    }
}
