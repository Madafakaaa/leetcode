package p1108_DefangingAnIPAddress;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/10 9:36
 */
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}