[Diagrama_de_Classes.drawio](https://github.com/user-attachments/files/35215155/Diagrama_de_Classes.drawio)
## 1. Diagrama de Classes

[Uploading Diagrama_de_Classes.drawio…]<mxfile host="app.diagrams.net" agent="ChatGPT">
  <diagram name="Diagrama de Classes" id="diagram-3673896">
    <mxGraphModel dx="1992" dy="902" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1580" pageHeight="1030" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="title" parent="1" style="text;html=1;align=center;verticalAlign=middle;fontSize=22;fontColor=#17365D;" value="&lt;b&gt;Diagrama de Classes — Sistema de Gestão do Lava Rápido&lt;/b&gt;" vertex="1">
          <mxGeometry height="45" width="850" x="360" y="20" as="geometry" />
        </mxCell>
        <mxCell id="pmodel" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#DCE6F1;strokeColor=#6C8EBF;fontColor=#17365D;fontSize=14;align=center;verticalAlign=middle;" value="&lt;b&gt;MODELO&lt;/b&gt;&lt;br&gt;&lt;font style=&#39;font-size:11px&#39;&gt;Dados e entidades do sistema&lt;/font&gt;" vertex="1">
          <mxGeometry height="48" width="400" x="30" y="85" as="geometry" />
        </mxCell>
        <mxCell id="pservice" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#DCE6F1;strokeColor=#6C8EBF;fontColor=#17365D;fontSize=14;align=center;verticalAlign=middle;" value="&lt;b&gt;SERVIÇOS&lt;/b&gt;&lt;br&gt;&lt;font style=&#39;font-size:11px&#39;&gt;Regras e operações&lt;/font&gt;" vertex="1">
          <mxGeometry height="48" width="330" x="480" y="85" as="geometry" />
        </mxCell>
        <mxCell id="pview" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#DCE6F1;strokeColor=#6C8EBF;fontColor=#17365D;fontSize=14;align=center;verticalAlign=middle;" value="&lt;b&gt;TELAS&lt;/b&gt;&lt;br&gt;&lt;font style=&#39;font-size:11px&#39;&gt;Interface com o usuário&lt;/font&gt;" vertex="1">
          <mxGeometry height="48" width="300" x="850" y="85" as="geometry" />
        </mxCell>
        <mxCell id="pcontroller" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#DCE6F1;strokeColor=#6C8EBF;fontColor=#17365D;fontSize=14;align=center;verticalAlign=middle;" value="&lt;b&gt;CONTROLADORES&lt;/b&gt;&lt;br&gt;&lt;font style=&#39;font-size:11px&#39;&gt;Intermediação entre telas e serviços&lt;/font&gt;" vertex="1">
          <mxGeometry height="48" width="370" x="1190" y="85" as="geometry" />
        </mxCell>
        <mxCell id="Cliente" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Cliente&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;− id: inteiro&lt;br&gt;− nome: texto&lt;br&gt;− cpf: texto&lt;br&gt;− telefone: texto&lt;br&gt;− email: texto" vertex="1">
          <mxGeometry height="155" width="360" x="50" y="155" as="geometry" />
        </mxCell>
        <mxCell id="Veiculo" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Veículo&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;− id: inteiro&lt;br&gt;− cliente: Cliente&lt;br&gt;− placa do veículo: texto" vertex="1">
          <mxGeometry height="125" width="360" x="50" y="340" as="geometry" />
        </mxCell>
        <mxCell id="TipoServico" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Tipo de Serviço&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;− id: inteiro&lt;br&gt;− nome: texto&lt;br&gt;− descrição: texto&lt;br&gt;− preço: decimal" vertex="1">
          <mxGeometry height="135" width="360" x="50" y="495" as="geometry" />
        </mxCell>
        <mxCell id="Agendamento" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Agendamento&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;− id: inteiro&lt;br&gt;− veículo: Veículo&lt;br&gt;− tipo de serviço: Tipo de Serviço&lt;br&gt;− data e hora: data/hora&lt;br&gt;− situação: Situação do Agendamento" vertex="1">
          <mxGeometry height="160" width="360" x="50" y="660" as="geometry" />
        </mxCell>
        <mxCell id="Status" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Situação do Agendamento «enumeração»&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;AGENDADO — Agendado&lt;br&gt;CANCELADO — Cancelado&lt;br&gt;CONCLUIDO — Concluído&lt;br&gt;− descrição: texto&lt;br&gt;+ obter descrição(): texto" vertex="1">
          <mxGeometry height="140" width="360" x="50" y="850" as="geometry" />
        </mxCell>
        <mxCell id="ServicoCliente" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Serviço de Clientes&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Responsável pelas operações de clientes" vertex="1">
          <mxGeometry height="85" width="310" x="490" y="155" as="geometry" />
        </mxCell>
        <mxCell id="ServicoVeiculo" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Serviço de Veículos&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;− veículos: lista de Veículo&lt;br&gt;+ listar todos(): lista de Veículo&lt;br&gt;+ listar por cliente(id): lista de Veículo&lt;br&gt;+ adicionar(cliente, placa): Veículo&lt;br&gt;+ atualizar(id, cliente, placa): vazio&lt;br&gt;+ excluir(id): vazio" vertex="1">
          <mxGeometry height="190" width="310" x="490" y="270" as="geometry" />
        </mxCell>
        <mxCell id="ServicoTipo" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Serviço de Tipos de Serviço&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Responsável pelas operações de tipos de serviço" vertex="1">
          <mxGeometry height="95" width="310" x="490" y="490" as="geometry" />
        </mxCell>
        <mxCell id="ServicoAg" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Serviço de Agendamentos&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Responsável pelas operações de agendamento" vertex="1">
          <mxGeometry height="95" width="310" x="490" y="615" as="geometry" />
        </mxCell>
        <mxCell id="TelaCliente" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Tela de Clientes&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Interface de cadastro e consulta de clientes" vertex="1">
          <mxGeometry height="85" width="285" x="865" y="155" as="geometry" />
        </mxCell>
        <mxCell id="TelaVeiculo" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Tela de Veículos&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Interface de cadastro e consulta de veículos" vertex="1">
          <mxGeometry height="85" width="285" x="865" y="270" as="geometry" />
        </mxCell>
        <mxCell id="TelaServico" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Tela de Serviços&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Interface de cadastro e consulta de serviços" vertex="1">
          <mxGeometry height="85" width="285" x="865" y="385" as="geometry" />
        </mxCell>
        <mxCell id="TelaAgenda" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Tela da Agenda&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Interface para agendar e consultar serviços" vertex="1">
          <mxGeometry height="85" width="285" x="865" y="500" as="geometry" />
        </mxCell>
        <mxCell id="CtrlCliente" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Controlador de Clientes&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Coordena a tela e o serviço de clientes" vertex="1">
          <mxGeometry height="85" width="330" x="1205" y="155" as="geometry" />
        </mxCell>
        <mxCell id="CtrlVeiculo" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Controlador de Veículos&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Coordena a tela e os serviços de veículos e clientes" vertex="1">
          <mxGeometry height="100" width="330" x="1205" y="270" as="geometry" />
        </mxCell>
        <mxCell id="CtrlServico" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Controlador de Serviços&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Coordena a tela e o serviço de tipos de serviço" vertex="1">
          <mxGeometry height="85" width="330" x="1205" y="400" as="geometry" />
        </mxCell>
        <mxCell id="CtrlAg" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=#6C8EBF;fontColor=#202124;fontSize=12;align=left;verticalAlign=top;spacing=8;" value="&lt;b&gt;Controlador de Agendamentos&lt;/b&gt;&lt;hr align=&#39;center&#39;/&gt;Coordena a agenda e os serviços necessários" vertex="1">
          <mxGeometry height="85" width="330" x="1205" y="515" as="geometry" />
        </mxCell>
        <mxCell id="e1" edge="1" parent="1" source="Cliente" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;startArrow=none;endArrow=none;strokeColor=#3D85C6;" target="Veiculo" value="1     possui     0..*">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="e2" edge="1" parent="1" source="Veiculo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;startArrow=none;endArrow=none;strokeColor=#3D85C6;" target="Agendamento" value="1     recebe     0..*">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="e3" edge="1" parent="1" source="TipoServico" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;startArrow=none;endArrow=none;strokeColor=#3D85C6;" target="Agendamento" value="1     é escolhido em     0..*">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="e4" edge="1" parent="1" source="Agendamento" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;endArrow=open;strokeColor=#3D85C6;" target="Status" value="possui uma situação">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="ec0" edge="1" parent="1" source="CtrlCliente" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="TelaCliente" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="ec1" edge="1" parent="1" source="CtrlCliente" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="ServicoCliente" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="1370" y="250" />
              <mxPoint x="645" y="250" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec2" edge="1" parent="1" source="CtrlVeiculo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="TelaVeiculo" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="ec3" edge="1" parent="1" source="CtrlVeiculo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;exitX=0;exitY=0.5;exitDx=0;exitDy=0;" target="ServicoVeiculo" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="1205" y="360" />
              <mxPoint x="1040" y="360" />
              <mxPoint x="1040" y="365" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec4" edge="1" parent="1" source="CtrlVeiculo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="ServicoCliente" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="1370" y="260" />
              <mxPoint x="645" y="260" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec5" edge="1" parent="1" source="CtrlServico" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="TelaServico" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="ec6" edge="1" parent="1" source="CtrlServico" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="ServicoTipo" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="645" y="480" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec7" edge="1" parent="1" source="CtrlAg" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="TelaAgenda" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="ec8" edge="1" parent="1" source="CtrlAg" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="ServicoAg" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="645" y="600" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec9" edge="1" parent="1" source="CtrlAg" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;" target="ServicoVeiculo" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="820" y="590" />
              <mxPoint x="820" y="365" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="ec10" edge="1" parent="1" source="CtrlAg" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#999999;entryX=1;entryY=0.5;entryDx=0;entryDy=0;" target="ServicoTipo" value="">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="1370" y="490" />
              <mxPoint x="800" y="490" />
            </Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="es0" edge="1" parent="1" source="ServicoCliente" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#82B366;" target="Cliente" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="es1" edge="1" parent="1" source="ServicoVeiculo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#82B366;" target="Veiculo" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="es2" edge="1" parent="1" source="ServicoTipo" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#82B366;" target="TipoServico" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="es3" edge="1" parent="1" source="ServicoAg" style="edgeStyle=orthogonalEdgeStyle;rounded=1;html=1;dashed=1;endArrow=open;strokeColor=#82B366;" target="Agendamento" value="">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="legend" parent="1" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFF2CC;strokeColor=#D6B656;fontSize=12;align=left;spacing=8;" value="&lt;b&gt;Legenda&lt;/b&gt;&lt;br&gt;Linhas contínuas: relacionamentos entre entidades.&lt;br&gt;Linhas tracejadas: comunicação ou dependência entre camadas." vertex="1">
          <mxGeometry height="90" width="650" x="490" y="770" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
()


**Relacionamento principal:** um cliente pode possuir vários veículos (`1:N`). Cada veículo pertence a um único cliente. Cada agendamento é feito para um veículo específico.

## 2. Diagrama de Sequência — Agendamento

[Diagrama_de_Sequencia.drawio](https://github.com/user-attachments/files/35215325/Diagrama_de_Sequencia.drawio)
<?xml version='1.0' encoding='utf-8'?>
<mxfile host="app.diagrams.net" modified="2026-11-21T16:30:00.000Z" agent="ChatGPT" version="24.7.17" type="device">
  <diagram id="seq-lava-rapido-prof" name="Diagrama de Sequência">
    <mxGraphModel dx="1800" dy="1400" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1900" pageHeight="1550" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="bg" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#FFFFFF;strokeColor=none;" parent="1" vertex="1">
          <mxGeometry x="0" y="0" width="1900" height="1550" as="geometry" />
        </mxCell>
        <mxCell id="title" value="Agendamento de serviço para um veículo" style="text;html=1;align=left;verticalAlign=middle;whiteSpace=wrap;rounded=0;strokeColor=none;fillColor=none;fontSize=28;fontStyle=1;fontColor=#172B4D;" parent="1" vertex="1">
          <mxGeometry x="55" y="25" width="1300" height="48" as="geometry" />
        </mxCell>
        <mxCell id="subtitle" value="Fluxo principal de criação de agendamento — arquitetura MVC" style="text;html=1;align=left;verticalAlign=middle;whiteSpace=wrap;rounded=0;strokeColor=none;fillColor=none;fontSize=15;fontColor=#5E6C84;" parent="1" vertex="1">
          <mxGeometry x="58" y="76" width="1300" height="30" as="geometry" />
        </mxCell>
        <mxCell id="legend" value="&lt;b&gt;Fluxo:&lt;/b&gt; seleção dos dados → validação → criação → atualização da agenda" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#F4F7FB;strokeColor=#D9E2F0;fontColor=#344563;fontSize=13;align=left;spacingLeft=14;" parent="1" vertex="1">
          <mxGeometry x="55" y="120" width="1790" height="42" as="geometry" />
        </mxCell>
        <mxCell id="user" value="Usuário" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#344563;strokeColor=#344563;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="95" y="190" width="155" height="56" as="geometry" />
        </mxCell>
        <mxCell id="user_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="172.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="view" value="TelaAgenda" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#0B6E99;strokeColor=#0B6E99;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="405" y="190" width="155" height="56" as="geometry" />
        </mxCell>
        <mxCell id="view_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="482.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="controller" value="ControladorAgendamento" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#6554C0;strokeColor=#6554C0;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="755" y="190" width="205" height="56" as="geometry" />
        </mxCell>
        <mxCell id="controller_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="857.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="service" value="ServiçoAgendamento" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#00875A;strokeColor=#00875A;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="1125" y="190" width="185" height="56" as="geometry" />
        </mxCell>
        <mxCell id="service_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="1217.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="model" value="Agendamento" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#BF6A02;strokeColor=#BF6A02;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="1510" y="190" width="155" height="56" as="geometry" />
        </mxCell>
        <mxCell id="model_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="1587.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="dialog" value="Janela de mensagem" style="rounded=1;whiteSpace=wrap;html=1;fillColor=#5E6C84;strokeColor=#5E6C84;fontColor=#FFFFFF;fontSize=14;fontStyle=1;align=center;verticalAlign=middle;arcSize=12;" parent="1" vertex="1">
          <mxGeometry x="1740" y="190" width="155" height="56" as="geometry" />
        </mxCell>
        <mxCell id="dialog_life" value="" style="shape=line;html=1;strokeColor=#AAB7C4;strokeWidth=1.4;dashed=1;dashPattern=5 5;rounded=0;" parent="1" vertex="1">
          <mxGeometry x="1817.5" y="246" width="0" height="1180" as="geometry" />
        </mxCell>
        <mxCell id="act_view" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#D6EEF7;strokeColor=#8C9BAB;strokeWidth=1;" parent="1" vertex="1">
          <mxGeometry x="475" y="335" width="12" height="1040" as="geometry" />
        </mxCell>
        <mxCell id="act_controller" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#E7E2FA;strokeColor=#8C9BAB;strokeWidth=1;" parent="1" vertex="1">
          <mxGeometry x="850" y="390" width="12" height="930" as="geometry" />
        </mxCell>
        <mxCell id="act_service" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#DDF3E8;strokeColor=#8C9BAB;strokeWidth=1;" parent="1" vertex="1">
          <mxGeometry x="1210" y="585" width="12" height="570" as="geometry" />
        </mxCell>
        <mxCell id="act_model" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#FCE8D5;strokeColor=#8C9BAB;strokeWidth=1;" parent="1" vertex="1">
          <mxGeometry x="1570" y="700" width="12" height="105" as="geometry" />
        </mxCell>
        <mxCell id="act_dialog" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#E8EDF3;strokeColor=#8C9BAB;strokeWidth=1;" parent="1" vertex="1">
          <mxGeometry x="1810" y="1115" width="12" height="105" as="geometry" />
        </mxCell>
        <mxCell id="m1" value="Seleciona veículo, serviço e data/hora" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="172.5" y="310" as="sourcePoint" />
            <mxPoint x="482.5" y="310" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m2" value="Clica em &lt;b&gt;Agendar&lt;/b&gt;" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="172.5" y="355" as="sourcePoint" />
            <mxPoint x="482.5" y="355" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m3" value="Evento do botão Agendar" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="482.5" y="405" as="sourcePoint" />
            <mxPoint x="857.5" y="405" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m4" value="getVeiculoSelecionado()" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="455" as="sourcePoint" />
            <mxPoint x="482.5" y="455" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m5" value="Veículo selecionado" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="482.5" y="485" as="sourcePoint" />
            <mxPoint x="857.5" y="485" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m6" value="getServicoSelecionado()" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="525" as="sourcePoint" />
            <mxPoint x="482.5" y="525" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m7" value="Tipo de serviço selecionado" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="482.5" y="555" as="sourcePoint" />
            <mxPoint x="857.5" y="555" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m8" value="getDataHoraSelecionada()" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="595" as="sourcePoint" />
            <mxPoint x="482.5" y="595" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m9" value="Data e hora escolhidas" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="482.5" y="625" as="sourcePoint" />
            <mxPoint x="857.5" y="625" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m10" value="agendar(veiculo, tipoServico, dataHora)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="675" as="sourcePoint" />
            <mxPoint x="1217.5" y="675" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m11" value="validarEntrada(veiculo, tipoServico, dataHora)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#00875A;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="725" as="sourcePoint" />
            <mxPoint x="1218.5" y="725" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m12" value="verificarConflito(dataHora, -1)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#00875A;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="775" as="sourcePoint" />
            <mxPoint x="1218.5" y="775" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="alt_frame" value="" style="rounded=0;whiteSpace=wrap;html=1;fillColor=none;strokeColor=#6554C0;strokeWidth=1.5;dashed=1;dashPattern=8 4;" parent="1" vertex="1">
          <mxGeometry x="105" y="820" width="1720" height="610" as="geometry" />
        </mxCell>
        <mxCell id="alt_tag" value="alt" style="rounded=0;whiteSpace=wrap;html=1;fillColor=#6554C0;strokeColor=#6554C0;fontColor=#FFFFFF;fontSize=13;fontStyle=1;align=center;" parent="1" vertex="1">
          <mxGeometry x="105" y="820" width="62" height="30" as="geometry" />
        </mxCell>
        <mxCell id="success_guard" value="[Dados válidos e horário disponível]" style="text;html=1;align=left;verticalAlign=middle;strokeColor=none;fillColor=none;fontColor=#00875A;fontSize=13;fontStyle=1;" parent="1" vertex="1">
          <mxGeometry x="180" y="827" width="480" height="24" as="geometry" />
        </mxCell>
        <mxCell id="divider_alt" value="" style="shape=line;html=1;strokeColor=#9F8FEF;strokeWidth=1.2;dashed=1;dashPattern=6 4;" parent="1" vertex="1">
          <mxGeometry x="105" y="1160" width="1720" height="0" as="geometry" />
        </mxCell>
        <mxCell id="error_guard" value="[Dados inválidos ou horário já ocupado]" style="text;html=1;align=left;verticalAlign=middle;strokeColor=none;fillColor=none;fontColor=#BF2600;fontSize=13;fontStyle=1;" parent="1" vertex="1">
          <mxGeometry x="180" y="1168" width="480" height="24" as="geometry" />
        </mxCell>
        <mxCell id="m13" value="&lt;&lt;criar&gt;&gt; Agendamento(veiculo, tipoServico, dataHora)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="875" as="sourcePoint" />
            <mxPoint x="1587.5" y="875" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m14" value="adicionar à lista de agendamentos" style="edgeStyle=none;html=1;rounded=0;strokeColor=#00875A;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="925" as="sourcePoint" />
            <mxPoint x="1218.5" y="925" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m15" value="Agendamento criado" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="965" as="sourcePoint" />
            <mxPoint x="857.5" y="965" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m16" value="listarTodos()" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="1010" as="sourcePoint" />
            <mxPoint x="1217.5" y="1010" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m17" value="Lista atualizada de agendamentos" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="1040" as="sourcePoint" />
            <mxPoint x="857.5" y="1040" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m18" value="exibirAgendamentos(lista)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="1080" as="sourcePoint" />
            <mxPoint x="482.5" y="1080" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m19" value="limparCampos()" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="1115" as="sourcePoint" />
            <mxPoint x="482.5" y="1115" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m20" value="Exibe confirmação: “Agendamento realizado com sucesso.”" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="1138" as="sourcePoint" />
            <mxPoint x="1817.5" y="1138" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m21" value="Confirmação apresentada" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1817.5" y="1150" as="sourcePoint" />
            <mxPoint x="172.5" y="1150" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m22" value="Lança IllegalArgumentException com a causa da validação" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1217.5" y="1235" as="sourcePoint" />
            <mxPoint x="857.5" y="1235" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m23" value="erro(mensagem)" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=block;endFill=1;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="857.5" y="1280" as="sourcePoint" />
            <mxPoint x="1817.5" y="1280" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="m24" value="Exibe aviso e solicita correção dos dados/horário" style="edgeStyle=none;html=1;rounded=0;strokeColor=#344563;strokeWidth=1.5;endArrow=open;endFill=0;fontSize=13;fontColor=#253858;labelBackgroundColor=#FFFFFF;align=center;verticalAlign=bottom;dashed=1;dashPattern=6 4;" edge="1" parent="1">
          <mxGeometry relative="1" as="geometry">
            <mxPoint x="1817.5" y="1325" as="sourcePoint" />
            <mxPoint x="172.5" y="1325" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="note" value="&lt;b&gt;Observação:&lt;/b&gt; o serviço valida campos obrigatórios e impede dois agendamentos ativos no mesmo dia e horário. Em caso de sucesso, o controlador atualiza a tabela, limpa o formulário e apresenta a confirmação." style="rounded=1;whiteSpace=wrap;html=1;fillColor=#FFF8E6;strokeColor=#F2CC60;fontColor=#5D4A1A;fontSize=12;align=left;spacing=12;" parent="1" vertex="1">
          <mxGeometry x="55" y="1460" width="1790" height="58" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
