using System;
using Antlr4.Runtime.Misc;
namespace projeto_compiler.CustomListeners; // ou o namespace dos arquivos gerados

public class LangDefCustomListener : LangDefBaseListener
{
    public override void EnterCmdWrite(LangDefParser.CmdWriteContext context)
    {
        var idToken = context.ID();
        if (idToken != null)
        {
            Console.WriteLine($"ID: {idToken.GetText()}");
        }
    }
}