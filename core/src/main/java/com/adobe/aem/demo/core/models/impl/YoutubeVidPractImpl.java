package com.adobe.aem.demo.core.models.impl;

import com.adobe.aem.demo.core.models.YoutubeVideoPract;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        adapters = YoutubeVideoPract.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class YoutubeVidPractImpl implements YoutubeVideoPract {

    @ValueMapValue
    private String videoId;

    @ValueMapValue
    private int videoNumber;

    @ValueMapValue
    private String videoDescription;

    @Override
    public String getVideoId() {
        return videoId;
    }

    @Override
    public int getVideoNumber() {
        return videoNumber;
    }

    @Override
    public String getVideoDescription() {
        return videoDescription;
    }
}
