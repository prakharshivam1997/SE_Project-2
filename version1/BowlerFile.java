package version1;
/* BowlerFile.java
 *
 *  Version:
 *  		$Id$
 * 
 *  Revisions:
 * 		$Log: BowlerFile.java,v $
 * 		Revision 1.5  2003/02/02 17:36:45  ???
 * 		Updated comments to match javadoc format.
 * 		
 * 		Revision 1.4  2003/02/02 16:29:52  ???
 * 		Added ControlDeskEvent and ControlDeskObserver. Updated Queue to allow access to Vector so that contents could be viewed without destroying. Implemented observer model for most of ControlDesk.
 * 		
 * 
 */

/**
 * Class for interfacing with Bowler database
 *
 */

import java.util.*;
import java.io.*;

class BowlerFile {

	private static final int _2 = 2;
	private static final int _1 = 1;
	public static final int _0 = 0;
	/** The location of the bowelr database */
	private static String BOWLER_DAT = Config.bowler_file_name;

    /**
     * Retrieves bowler information from the database and returns a Bowler objects with populated fields.
     *
     * @param nickName	the nickName of the bolwer to retrieve
     *
     * @return a Bowler object
     * 
     */

	public static Bowler getBowlerInfo(String nickName)
		throws IOException, FileNotFoundException {

		BufferedReader in = new BufferedReader(new FileReader(BOWLER_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] bowler = data.split("\t");
			if (nickName.equals(bowler[_0])) {
				System.out.println(
					"Nick: "
						+ bowler[_0]
						+ " Full: "
						+ bowler[_1]
						+ " email: "
						+ bowler[_2]);
				return (new Bowler(bowler[_0], bowler[_1], bowler[_2]));
			}
		}
		System.out.println("Nick not found...");
		return null;
	}
	
	public static Bowler registerPatron(String nickName) {
		Bowler patron = null;

		try {
			// only one patron / nick.... no dupes, no checks

			patron = getBowlerInfo(nickName);

		} catch (FileNotFoundException e) {
			System.err.println("Error..." + e);
		} catch (IOException e) {
			System.err.println("Error..." + e);
		}

		return patron;
	}


    /**
     * Stores a Bowler in the database
     *
     * @param nickName	the NickName of the Bowler
     * @param fullName	the FullName of the Bowler
     * @param email	the E-mail Address of the Bowler
     *
     */

	public static void putBowlerInfo(
		String nickName,
		String fullName,
		String email)
		throws IOException, FileNotFoundException {

		String data = nickName + "\t" + fullName + "\t" + email + "\n";

		RandomAccessFile out = new RandomAccessFile(BOWLER_DAT, "rw");
		out.skipBytes((int) out.length());
		out.writeBytes(data);
		out.close();
	}
	
	
	public static void removeBowler(String nickName) 
			throws IOException, FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader(BOWLER_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] bowler = data.split("\t");
			if (nickName.equals(bowler[0])) {
				break;
			}
		}
		
		
		File inputFile = new File(BOWLER_DAT);
		File tempFile = new File("myTempFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = data;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		boolean successful = tempFile.renameTo(inputFile);
		
		
	}

    /**
     * Retrieves a list of nicknames in the bowler database
     *
     * @return a Vector of Strings
     * 
     */

	public static Vector getBowlers()
		throws IOException, FileNotFoundException {

		Vector allBowlers = new Vector();

		BufferedReader in = new BufferedReader(new FileReader(BOWLER_DAT));
		String data;
		while ((data = in.readLine()) != null) {
			// File format is nick\tfname\te-mail
			String[] bowler = data.split("\t");
			//"Nick: bowler[0] Full: bowler[1] email: bowler[2]
			allBowlers.add(bowler[_0]);
		}
		return allBowlers;
	}

}