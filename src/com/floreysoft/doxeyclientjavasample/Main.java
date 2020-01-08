package com.floreysoft.doxeyclientjavasample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.floreysoft.doxey.api.DefaultApi;
import com.floreysoft.doxey.invoke.ApiClient;
import com.floreysoft.doxey.invoke.ApiException;
import com.floreysoft.doxey.model.Params;
import com.floreysoft.doxey.model.Params.FormatEnum;

public class Main {

  public static void main(String[] args) throws ApiException {
    String apikey = "internal"; // please set to your apikey

    ApiClient cl = new ApiClient();
    cl.setReadTimeout(1000 * 240);
    cl.setBasePath("https://api.doxey.io");
    cl.setApiKey(apikey);

    DefaultApi api = new DefaultApi(cl);

    Map<String, Object> model = new HashMap<>();
    model.put("name", "John Doe");
    model.put("company", "ACME");
    model.put("address", "1234 Market Street, San Francisco, CA 94103, United States");
    model.put("date", "2019-09-23T18:25:00.000Z");
    model.put("invoiceNumber", "INV-12345678");
    model.put("signer", "Cora Nilson");
    model.put("signature", "https://www.doxey.io/images/signature.png");
    model.put("subtotal", 1301);
    model.put("vatRate", 19);
    model.put("vat", 247.19);
    model.put("total", 1548.19);

    List<Object> items = new ArrayList<>();

    Map<String, Object> item = new HashMap<>();
    item.put("name", "Project Setup");
    item.put("description", "Create github repo, setup timetracker and Slack channels");
    item.put("amount", 90);
    items.add(item);

    item = new HashMap<>();
    item.put("name", "Optimize Photos");
    item.put("description", "Scan, crop and scale images to reduce loading times");
    item.put("amount", 340.50);
    items.add(item);

    item = new HashMap<>();
    item.put("name", "Website structure");
    item.put("description", "Copy blank boostrap template. Setup pages and adjust links");
    item.put("amount", 250.50);
    items.add(item);

    item = new HashMap<>();
    item.put("name", "CSS theme");
    item.put("description", "Create CSS styles according to CI");
    item.put("amount", 620);
    items.add(item);

    model.put("items", items);

    Params p = new Params();
    p.setCurrency("EUR");
    p.setLocale("de_DE");
    p.setTimezone("GMT+01:00");
    p.setApiKey(apikey);
    p.setFormat(FormatEnum.PDF);
    p.setModel(model);
    p.setTemplate("https://docs.google.com/document/d/1urL-JV2m85jry1_tatbjSFBjUZgGiMmwwNR9X8UTUTg/edit");

    File f = api.mergePost(p);
    System.out.println(f.getAbsolutePath());
  }
}









