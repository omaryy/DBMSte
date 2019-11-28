import java.io.IOException;

import org.xml.sax.SAXException;

public interface Database {
	/**
	 * Create database with the given name, or use it if exists. This method
	 * performs a call to executeStructureQuery() internally to create or drop
	 * the database.
	 * 
	 * @param databaseName
	 *            Database name, can be a path not a name only
	 * @param dropIfExists
	 *            if true, then delete the database and recreate it again.
	 * @return the absolute path of the database directory wherein data is
	 *         stored
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public String createDatabase(String databaseName, boolean dropIfExists) throws SAXException, IOException;

	/**
	 * Creates/drops table or database.
	 * 
	 * @param query
	 *            create or drop, table or database query
	 * @returns true if success, or false otherwise
	 * @throws SQLException
	 *             syntax error
	 */
	public boolean executeStructureQuery(String query)
			throws java.sql.SQLException;

	/**
	 * Select from table
	 * 
	 * @param query
	 *            select query
	 * @return the selected records or an empty array if no records match.
	 *         Columns types must be preserved (i.e. int column returns Integer
	 *         objects)
	 * @throws SQLException
	 *             syntax error
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public Object[][] executeQuery(String query) throws java.sql.SQLException, SAXException, IOException;

	/**
	 * Insert or update or delete the data
	 * 
	 * @param query
	 *            data manipulation query
	 * @return the updated rows count
	 * @throws SQLException
	 *             syntax error
	 */
	public int executeUpdateQuery(String query) throws java.sql.SQLException;

}
