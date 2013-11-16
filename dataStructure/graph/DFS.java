/**
 *DFS using adjacency list
 * still something wrong with the impe

*/
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
class Vertex{
	String name ;
	boolean visited;
	Vertex(String name){
		this.name = name;
		this.visited = false;	
	}
	
	boolean isVisited(){

	return this.visited;
	}
}
public class DFS{
	Map<Vertex,List<Vertex>> verticesList;
	
	DFS(){
		verticesList = new HashMap<Vertex,List<Vertex>>();
	}
	
	void add(Vertex v,List<Vertex> list){
		verticesList.put(v,list);
	}

	Map<Vertex,List<Vertex>> getList(){

		return  this.verticesList;
	}

	List<Vertex> getList(Vertex v){
	return this.verticesList.get(v);
        }
	
	Vertex getRoot(String name){
		Iterator it = this.getList().keySet().iterator();
		while(it.hasNext()){
			Vertex z =(Vertex) it.next();
			if(z.name.equals(name)){
				//System.out.println("found"+ z.name);
				return z;
			}
		}
		return null;
		
	}
	void dfsTraversal(DFS g,Vertex v ){
		if(!v.isVisited()){
		System.out.println(v.name);
		v.visited = true;
		List<Vertex> list = g.getList(v);
		if(list!=null){
			//System.out.println("List of"+ v.name);
			Iterator it = g.getList(v).iterator();
			while(it.hasNext()){
				dfsTraversal(g,(Vertex)it.next());
		}
		}else return;
		}
	}
	
	public static void main(String [] args){

		DFS g = new DFS();
		Scanner inp = new Scanner(System.in);
 		System.out.println("Eneter the number of Vertices");	
		int n = inp.nextInt();
		Vertex v ;
	        List<Vertex> adjList;
 		
		int i = 1;
		while(i <=n){
			System.out.println("Enter the vertex");
			v = new Vertex(inp.next());
			System.out.println("Enter the adj list");
			adjList = new ArrayList<Vertex>();
			while(true){
				System.out.println("Press c for contuning to add into adjList");
				String a = inp.next();
				if(a.equals("c")){
					System.out.println("Enter the adjvertex");
					adjList.add(new Vertex(inp.next()));
				}
				else	break;
			
			}
			g.add(v,adjList);
			i++;
		}
                Map<Vertex,List<Vertex>> list = g.getList(); 		
		Iterator keyIt = list.keySet().iterator();
		while(keyIt.hasNext()){
			Vertex w = (Vertex)keyIt.next();
			System.out.printf(w.name+":");
			Iterator adjListIt = list.get(w).iterator();
			while(adjListIt.hasNext()){
				Vertex u = (Vertex)adjListIt.next();
				System.out.printf(u.name+"->"); 
			}
			System.out.println();

		}
		System.out.println("Enter the root node for dfsTraversal");
		Vertex z = g.getRoot(inp.next());
		System.out.println("DFS for the tree is ");
		g.dfsTraversal(g,z);
	}
	




}
