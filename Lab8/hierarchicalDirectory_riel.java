import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hierarchicalDirectory_riel {
    public static void main(String []args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Node<String> root = new Node<String>("/");
        Node<String> currentPath = root;
        while(true){
            workingDirectory(currentPath);
            String[] cmd_line = bf.readLine().split(" ");
            // for(int i=0;i<cmd_line.length;i++)
            //     System.out.print(cmd_line[i]+",");
            // for(String word : cmd)
            //     String[] cmd_line = [word];
            // System.out.println();

            String cmd,fileName = "";
            int arguments = cmd_line.length;
            if(arguments == 1)
                cmd = cmd_line[0];
            else if(arguments == 2){
                cmd = cmd_line[0];
                fileName = cmd_line[1];
            }
            else{
                System.out.println("Error at command");
                continue;
            }

            //list of command
            if(cmd.equals("cd") && arguments == 2){
                // System.out.println(currentPath.getData());
                // System.out.println(root.getData());
                if(fileName.equals("..") && currentPath.getData() != root.getData()){
                    currentPath = currentPath.getParent();
                }
                else if(fileName.equals("..") && currentPath.getData() ==(root.getData())){
                    System.out.println("In Root");
                }
                else{
                    // System.out.println("Error");
                    if(currentPath.findFolder(fileName) == null)
                        System.out.printf("%s not found\n",fileName);
                    else{
                        currentPath = currentPath.findFolder(fileName);
                    }
                }
            }
            else if(cmd.equals("mkdir") && arguments == 2)
                currentPath.addChild(new Node<String>(fileName));
            else if(cmd.equals("mkfile") && arguments == 2)
                currentPath.addChild(new Node<String>(fileName));
            else if(cmd.equals("ls")){
                System.out.println("List all files:");
                currentPath.listChildren();
            }
            else if(cmd.equals("tree"))
                // System.out.println("Print the tree");
                currentPath.treeList(0);
            else if(cmd.equals("exit")){
                System.out.println("Exited");
                break;
            }
            else{
                System.out.println("Command does not exist. Please enter a valid one");
                continue;
            }
        }
    }

    public static void workingDirectory(Node<String> node){
        String path = "";
        Node<String> tempNode = node;
        while(tempNode.getData() != "/"){
            path = tempNode.getData() + "/" + path;
            tempNode = tempNode.getParent();
        }
        path = "/" + path;
        System.out.print(path+":~$");

    }
}

class Node<T> {
    private T data = null;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
    public Node<T> getParent(){
        return parent;
    }
    public void setParent(Node<T> parent){
        this.parent = parent;
    }

    public Node<T> addChild(Node<T> child){
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T>> children){
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<Node<T>> getChildren(){
        return children;
    }

    public Node<T> findFolder(String inputName){
        for(Node<T> file:this.children){
            String in = file.getData().toString();
            if(in.equals(inputName)){
                // return file.getData().toString();
                return file;
            }
        }
        return null;
    }

    public void listChildren(){
        for(Node<T>file:children)
            System.out.println(file.getData());
    }

    public void treeList(int level){
        if(level == 0){
            System.out.println("Directory List:");
        }
        for(int i=0;i<level;i++)
            System.out.print("-|");
        System.out.println(this.getData());

        if(children.size() != 0){
            for(Node<T> file:children)
                file.treeList(level + 1);
        }
    }
}