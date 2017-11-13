package com.lp.crudframework.xml;

public class XMLMapping {

    public static final String DATA = "data";
    public static final String TABLE = "table";
    public static final String FIELD = "field";
    public static final String LENGTH = "length";
    public static final String ID = "id";
    public static final String QUERIES = "queries";
    public static final String QUERY = "query";
    public static final String QUERY_TYPE = "type";
    public static final String CREATE = "create";
    public static final String EDIT = "edit";
    public static final String DELETE = "delete";
    public static final String FIND = "find";
    public static final String FIND_ID = "find-by-id";
    public static final String FIND_FIELD = "find-by-field";
    public static final String FIELD_NAME = "field-name";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    /*
     *  <data>
     *      <table name="user">
     *          <field name="id" id="true" />
     *          <field name="username" length="20" />
     *          <field name="password" length="20" password="true" />
     *          <field name="email" length="20" email="true" />
     *
     *              <queries>
     *                  <query type="create" />
     *                  <query type="edit" />
     *                  <query type="delete" />
     *                  <query type="find">
     *                      <find-by-field name="username" />
     *                      <find-by-field name="password" />
     *                  </query>
     *          </queries>
     *      </table>
     *  </data>
     */

}
