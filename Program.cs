//java -jar antlr-4.13.1-complete.jar -Dlanguage=CSharp -package projeto_compiler LangDef.g4 -o Modules/Grammar

using Antlr4.Runtime;
using projeto_compiler.CustomListeners;

namespace projeto_compiler;

public class Program
{
  private static void Main()
  {
    Console.WriteLine("_______ ANTLR calculator _______");
    while(true)
    {
      Console.Write("expression >> ");
      string? line = Console.ReadLine();
      if (line != null && line.Trim().ToLower() == "exit")
      {
        Console.WriteLine("Exiting calculator.");
        break;
      }
      if(String.IsNullOrWhiteSpace(line)){
        Console.WriteLine("Invalid expression!");
        continue;
      }

      CalculateExpression(line);
    }
  }

  private static void CalculateExpression(string line)
  {
    try
    {
      var inputStream = new AntlrInputStream(line);
      var lexer = new LangDefLexer(inputStream);
      var tokens = new CommonTokenStream(lexer);
      var parser = new LangDefParser(tokens);
      var tree = parser.start();
      var walker = new Antlr4.Runtime.Tree.ParseTreeWalker();
      walker.Walk(new LangDefCustomListener(), tree);
    }
    catch (Exception e)
    {
      Console.WriteLine(e.Message);
    }
  }
}