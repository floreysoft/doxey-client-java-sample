package com.floreysoft.doxeyclientjavasample;

import java.io.File;
import java.util.HashMap;
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









