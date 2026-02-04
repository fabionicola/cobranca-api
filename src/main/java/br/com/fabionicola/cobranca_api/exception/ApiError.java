package br.com.fabionicola.cobranca_api.exception;

import java.util.Map;

public class ApiError {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String method;
    private Map<String, String> fields;

    public ApiError() {}

    public ApiError(String timestamp, int status, String error, String message, String path, String method, Map<String, String> fields) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.method = method;
        this.fields = fields;
    }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public Map<String, String> getFields() { return fields; }
    public void setFields(Map<String, String> fields) { this.fields = fields; }
}