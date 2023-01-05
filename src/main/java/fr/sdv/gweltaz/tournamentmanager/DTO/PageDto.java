package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {
    private List<T> data;
    private PaginationContext context;
}
