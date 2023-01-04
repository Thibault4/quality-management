package fr.sdv.gweltaz.tournamentmanager.Controller;

import fr.sdv.gweltaz.tournamentmanager.DTO.ApiError;
import fr.sdv.gweltaz.tournamentmanager.DTO.ErrorCodeEnum;
import fr.sdv.gweltaz.tournamentmanager.Exception.IdMismatchException;
import fr.sdv.gweltaz.tournamentmanager.Exception.NoWinnerException;
import fr.sdv.gweltaz.tournamentmanager.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BaseAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ApiError handleNotFound(ResourceNotFoundException e, WebRequest request) {
        return ApiError.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(e.getMessage())
                .error(ErrorCodeEnum.RESOURCE_NOT_FOUND)
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IdMismatchException.class})
    protected ApiError handleBadRequest(IdMismatchException e, WebRequest request){
        return ApiError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .error(ErrorCodeEnum.ID_MISMATCH)
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {NoWinnerException.class})
    protected ApiError handleNoWinner(NoWinnerException e, WebRequest request)
    {
        return ApiError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .error(ErrorCodeEnum.NO_WINNER)
                .build();
    }
}
