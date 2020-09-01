package com.jm.dto;

import java.util.List;

public class PageDto<UserDto> {

    private Integer totalEntitiesCount;
    private Integer currentPage;
    private Integer pageCount;
    private Integer countOnPage;
    private List<UserDto> entities;

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

    public List<UserDto> getEntities() {
        return entities;
    }

    public void setEntities(List<UserDto> entities) {
        this.entities = entities;
    }
}
