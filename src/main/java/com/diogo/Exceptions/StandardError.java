package com.diogo.Exceptions;

public class StandardError {
  private Long timestamp;
  private Integer status;
  private String error;
  private String message;

  public StandardError(Long timestamp, Integer status, String error) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public StandardError(Long timestamp, Integer status, String error, String message) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.setMessage(message);
  }

  public StandardError() {
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

}
