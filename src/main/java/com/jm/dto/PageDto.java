package com.jm.dto;

import java.util.List;

public class PageDto<T> {

    private Integer totalEntitiesCount;
    private Integer currentPage;
    private Integer pageCount;
    private Integer countOnPage;
    private List<T> entities;

    public PageDto(Integer totalEntitiesCount, Integer currentPage, Integer pageCount, Integer countOnPage, List<T> entities) {
        this.totalEntitiesCount = totalEntitiesCount;
        this.currentPage = currentPage;
        this.pageCount = pageCount;
        this.countOnPage = countOnPage;
        this.entities = entities;
    }

    /* GETTERS AND SETTERS */

    public Integer getTotalEntitiesCount() {
        return totalEntitiesCount;
    }

    public void setTotalEntitiesCount(Integer totalEntitiesCount) {
        this.totalEntitiesCount = totalEntitiesCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCountOnPage() {
        return countOnPage;
    }

    public void setCountOnPage(Integer countOnPage) {
        this.countOnPage = countOnPage;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
}
