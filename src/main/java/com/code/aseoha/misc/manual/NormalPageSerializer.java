package com.code.aseoha.misc.manual;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import java.util.List;

public class NormalPageSerializer extends PageSerializer {

    public NormalPageSerializer() {
        super(str -> str.contentEquals("normal"));
    }

    @Override
    public List<Page> read(JsonObject root) {

        if(!root.has("text"))
            return Lists.newArrayList();

        List<Page> pages = Lists.newArrayList();

        Page page = new Page();
        String leftovers = page.parseString(root.get("text").getAsString());
        pages.add(page);

        //Handle overfill
        while(!leftovers.isEmpty()){
            Page p = new Page();
            leftovers = p.parseString(leftovers);
            pages.add(p);
        }

        return pages;
    }
}
