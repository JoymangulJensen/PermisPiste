package com.permispiste.errorhandlers;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/4/2017.
 */
public class ServiceHibernateException extends RuntimeException
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // --------------------------------
    public ServiceHibernateException()
    {    super(); }
    // --------------------------------
    public ServiceHibernateException(String message)
    {    super(message); }
    // --------------------------------
    public ServiceHibernateException(Throwable cause)
    {    super(cause); }
    // --------------------------------
    public ServiceHibernateException(String message, Throwable cause)
    {    super(message, cause); }
    // --------------------------------
}