package com.dem.es.service;

import com.dem.es.entity.po.ProjectInfo;
import com.dem.es.util.PageBean;

import java.io.IOException;
import java.util.List;

public interface ProjectInfoService {

    void batchAdd();

    String addOne(Long id) throws IOException;

    PageBean search(String kw, int page, int pageSize);

    PageBean searchProjectName(String kw);

    List<ProjectInfo> getAll();

    int deleteByProjectName(String name);

    Object queryMutiType(String kw,int page,int pageSize);
}
