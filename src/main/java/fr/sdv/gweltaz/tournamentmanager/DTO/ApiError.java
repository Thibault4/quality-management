package fr.sdv.gweltaz.tournamentmanager.DTO;

import lombok.Builder;

@Builder
public record ApiError(
        Integer code,
        String status,
        String message,
        ErrorCodeEnum error
)
{
}
