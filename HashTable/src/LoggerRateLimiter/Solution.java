package LoggerRateLimiter;

import java.util.HashMap;

class Logger {

    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            }
        }
        return false;
    }
}