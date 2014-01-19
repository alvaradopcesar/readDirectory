package readDirectory;

import java.io.*;

public class  Walkin{
	
	static int spc_count=-1;
	static String sDirectoryGeneral = "/Users/cesaralvarado/git/compensacionBcr";
	
  public static void main(String[] args){
	  
	  File aFile = new File(sDirectoryGeneral);
	  Process(aFile);
	  
  }
  
  static String getExtencion( String fileName ){
	  
	  String ext = "";
	  int pos_ini = fileName.lastIndexOf(".");
	  int pos_fin = fileName.length();
	  //System.out.println(pos_ini);
	  //System.out.println(pos_fin);
	  if (pos_ini > 0) {
		  //ext = fileName.substring(0, pos);
		  ext = fileName.substring(pos_ini+1 ,pos_fin);
	  }
	  
	  return ext;
  }
  
  static String getDirRelativo ( String dir ){
	  
	  return dir.replace(sDirectoryGeneral,"");
	  
  }
  
  static void Process(File aFile) {
	  
	  
	  String sfile = "";
	  String sdir = "";
	  
	  
	  spc_count++;
	  String spcs = "";
	  for (int i = 0; i < spc_count; i++)
		  spcs += " ";
	  
	  if(aFile.isFile()) {
		  	sfile = aFile.getName();
			  if ( !sfile.equals(".git") && 
				   !sfile.equals(".settings") && 
				   !sfile.equals(".project") &&
				   !sfile.equals(".DS_Store") &&
				   !sfile.equals(".classpath") &&
				   !sfile.equals(".gitignore") ) {

				  //System.out.println(spcs + "[FILE] " + aFile.getName());
				  //System.out.println( getDirRelativo(aFile.getParent()) + "|" + aFile.getName() + "|" + getExtencion(aFile.getName() ));
				  System.out.println(aFile.getName() + "|" + getExtencion(aFile.getName()) + "|" + getDirRelativo(aFile.getParent()) + "|" + "N" );
				  
				  //System.out.println(aFile.getParentFile() + "  ,  " + aFile.getName());
				  //aFile.getPath()
				  //aFile.getAbsolutePath() 
				  //aFile.getParent();
				  //aFile.getParentFile()
			  }	  
	  } 	
	  else if (aFile.isDirectory()) {
		  sdir = aFile.getName();
		  
		  if ( !sdir.equals(".git") && 
			   !sdir.equals(".settings") && 
			   !sdir.equals(".project") &&
			   !sdir.equals("build")) {
			  
			  
			  //System.out.println(spcs + "[DIR] " + aFile.getAbsolutePath());
			  //System.out.println(spcs + "[DIR] " + aFile.getName());
			  File[] listOfFiles = aFile.listFiles();
			  if(listOfFiles!=null) {
				  for (int i = 0; i < listOfFiles.length; i++)
					  Process(listOfFiles[i]);
			  } else {
				  System.out.println(spcs + " [ACCESS DENIED]");
			  }
			  
		  }
	  }
	  spc_count--;
  }
}