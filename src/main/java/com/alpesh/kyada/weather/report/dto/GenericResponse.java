package com.alpesh.kyada.weather.report.dto;

/**
 *
 * @author Alpesh
 * @param <T>
 */
public class GenericResponse<T> {

    private GenericResponseStatus status;
    private String message;
    private T data;

    public GenericResponse() {
    }

    public GenericResponse(GenericResponseStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public GenericResponseStatus getStatus() {
        return status;
    }

    public void setStatus(GenericResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "status=" + status + ", message=" + message + ", data=" + data + '}';
    }

}
