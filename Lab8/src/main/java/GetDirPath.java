import java.io.File;

public final class GetDirPath {
  private GetDirPath() {
  }

  public static String getDirectoryPath(String[] args) {
    if (args.length > 0) {
      return args[0];
    }

    String projectRoot = System.getProperty("user.dir");
    String relativePath = "files2";

    File lab8Dir = new File(projectRoot, "Lab8");
    if (lab8Dir.exists()) {
      return new File(lab8Dir, relativePath).getAbsolutePath();
    }

    File currentDirFile = new File(projectRoot, relativePath);
    if (currentDirFile.exists()) {
      return currentDirFile.getAbsolutePath();
    }

    return new File(projectRoot, relativePath).getAbsolutePath();
  }
}
