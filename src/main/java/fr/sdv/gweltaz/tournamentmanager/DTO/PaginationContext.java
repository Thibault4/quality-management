package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginationContext {
    private Integer page;
    private Integer pageSize;
    private Integer count;
    private Long total;
}
