//java -jar antlr-4.13.1-complete.jar -Dlanguage=CSharp -package projeto_compiler LangDef.g4 -o Modules/Grammar
using Antlr4.Runtime;
using projeto_compiler.CustomListeners;

namespace projeto_compiler;

public class Program
{
  private static void Main()
  {
    try
    {
      var inputFilePath = "input.izi";
      var fileContent = File.ReadAllText(inputFilePath);
      var inputStream = new AntlrInputStream(fileContent);
      var lexer = new LangDefLexer(inputStream);
      var tokens = new CommonTokenStream(lexer);
      var parser = new LangDefParser(tokens);
      var tree = parser.prog();
      var walker = new Antlr4.Runtime.Tree.ParseTreeWalker();
      walker.Walk(new LangDefCustomListener(), tree);
      Console.WriteLine(tree.ToStringTree(parser));
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
      throw;
    }
  }
}