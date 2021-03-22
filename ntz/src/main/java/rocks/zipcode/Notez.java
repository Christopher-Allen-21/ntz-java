package rocks.zipcode;

/**
 * ntz main command.
 */
public final class Notez {

    private FileMap filemap;

    public Notez() {

        this.filemap  = new FileMap();
    }
    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String argv[]) {
        boolean _debug = true;
        // for help in handling the command line flags and data!
        if (_debug) {
            System.err.print("Argv: [");
            for (String a : argv) {
                System.err.print(a+" ");
            }
            System.err.println("]");
        }

        Notez ntzEngine = new Notez();

        ntzEngine.loadDatabase();

        /*
         * You will spend a lot of time right here.
         *
         * instead of loadDemoEntries, you will implement a series
         * of method calls that manipulate the Notez engine.
         * See the first one:
         */
        ntzEngine.loadDemoEntries();

        ntzEngine.saveDatabase();

        if (argv.length == 0) { // there are no commandline arguments
            //just print the contents of the filemap.
            ntzEngine.printResults();
        } else {
            if (argv[0].equals("-r")) {
                ntzEngine.addToCategory("General", ntzEngine.argvToString(argv));
            }
            else if(argv[0].equals("-c")){
                ntzEngine.addToCategory(argv[1], ntzEngine.argvToString(argv));
            }
            else if(argv[0].equals("-f")){

            }
            // this should give you an idea about how to TEST the Notez engine
            // without having to spend lots of time messing with command line arguments.
        }
        /*
         * what other method calls do you need here to implement the other commands??
         */

    }
    public String argvToString(String[] argv){
        String noteToAdd = "";
        for(int i=2;i<argv.length;i++){
            noteToAdd += argv[i] + " ";
        }
        noteToAdd += argv[argv.length-1];
        return noteToAdd;
    }

    public void addToCategory(String key, String note) {
        if(filemap.containsKey(key)){
            filemap.get(key).add(note);
        }
        else{
            filemap.put(key,new NoteList(note));
        }
    }

    public void removeNote(int indexToRemove){

    }

    private void saveDatabase() {

        filemap.save();
    }

    private void loadDatabase() {

        filemap.load();
    }

    public void printResults() {

        System.out.println(this.filemap.toString());
    }

    public FileMap getFilemap() {
        return filemap;
    }

    public void loadDemoEntries() {
        filemap.put("General", new NoteList("The Very first Note"));
        filemap.put("note2", new NoteList("A secret second note"));
        filemap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        filemap.put("anotherNote", new NoteList("Hello from ZipCode!"));
    }
    /*
     * Put all your additional methods that implement commands like forget here...
     */

}
