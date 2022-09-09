package java_basic.manager_resort.controller;

import java_basic.manager_resort.models.person.Tourist;

import java.util.LinkedHashMap;
import java.util.Map;

public class VoucherController {
    // đề không rõ nên hardcode
    static int voucher10 = 3;
    static int voucher30 = 1;
    //11/11/1990 ->
    static int voucher50 = 1;

    static Map<Tourist, String> mapPersonGetVoucher;

        static {
            mapPersonGetVoucher = new LinkedHashMap<>();
        }

        public void setMapPersonGetVoucher(PromotionController personGetVoucher) {
            while (!personGetVoucher.isEmpty()) {
                if (voucher50 > 0) {
                    mapPersonGetVoucher.put(personGetVoucher.pop(), "voucher50");
                    voucher50--;
                    return;
                }
                if (voucher30 > 0) {
                    mapPersonGetVoucher.put(personGetVoucher.pop(), "voucher30");
                    voucher30--;
                    return;
                }
                if (voucher10 > 0) {
                    mapPersonGetVoucher.put(personGetVoucher.pop(), "voucher10");
                    voucher10--;
                    return;
                }
            }
        }

        public void displayMapVoucher() {
            for (Map.Entry<Tourist, String> entry : mapPersonGetVoucher.entrySet()) {
            System.out.printf("%s get %s\n", entry.getKey().toString(), entry.getValue());
        }
    }

    public void displayTouristUseService(){
        for (Map.Entry<Tourist, String> entry : mapPersonGetVoucher.entrySet()) {
            System.out.printf("%s\n", entry.getKey().toString());
        }
    }

    public Map.Entry<Tourist, String> searchTouristGetVoucher(String str) {
        for (Map.Entry<Tourist, String> entry : mapPersonGetVoucher.entrySet()) {
            if (entry.getKey().getId().equalsIgnoreCase(str)) return entry;
        }
        return null;
    }

}