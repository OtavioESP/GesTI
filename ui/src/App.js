// node version v20.12.2.
// yarn version v1.22.22
import "./App.css";
import CardTarefa from "./components/CardTarefa";
import ChartContainer from "./components/ChartContainer";
import Header from "./components/Header";
import BarChart from "./components/charts/BarChart";
import LineChart from "./components/charts/LineChart";
import PieChart from "./components/charts/PieChart";
import RadialBarChart from "./components/charts/RadialBarChart";
import { barData, lineData, lineDataBugs, pieData, radialData } from "./mocks";

function App() {
  return (
    <div
      className="App"
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        gap: "10px",
      }}
    >
      <Header />
      <div
        style={{
          display: "flex",
          flexDirection: "row",
          padding: "20px",
          gap: "50px",
        }}
      >
        <ChartContainer type={"pie"}>
          <PieChart data={pieData} />
        </ChartContainer>
        <ChartContainer type={"radial"}>
          <RadialBarChart data={radialData} />
        </ChartContainer>
      </div>
      <ChartContainer type={"linear"}>
        <LineChart data={lineData} title={"Tarefas entregues"} />
      </ChartContainer>
      <ChartContainer type={"linear"}>
        <LineChart data={lineDataBugs} title={"Bugs Relatados e Resolvidos"} />
      </ChartContainer>
      <ChartContainer type={"bar"}>
        <BarChart data={barData} title={"Bugs Relatados e Resolvidos"} />
      </ChartContainer>
      <CardTarefa
        type={"Bug"}
        system={"AGOS"}
        state={"Desenvolvimento"}
        color={"#D2D2D2"}
      />
      <CardTarefa
        type={"Feature"}
        system={"Agos"}
        state={"Em Homologação"}
        color={"#FFC227"}
      />
      <CardTarefa
        type={"Feature"}
        system={"Agos"}
        state={"Homologação Reprovada"}
        color={"#FF3473"}
      />
      <CardTarefa
        type={"Feature"}
        system={"Agos"}
        state={"Homologação Aprovada"}
        color={"#36F03B"}
      />
      <CardTarefa
        type={"Bug"}
        system={"Monitoria"}
        state={"Revisão"}
        color={"#2CBBF9"}
      />
      <CardTarefa
        type={"Feature"}
        system={"Agos"}
        state={"Revisão Reprovada"}
        color={"#004461"}
      />
      <CardTarefa
        type={"Bug"}
        system={"Monitoria"}
        state={"Revisão Aprovada"}
        color={"#ACE6FF"}
      />
      <CardTarefa
        type={"Feature"}
        system={"Agos"}
        state={"Em produção"}
        color={"#F022FF"}
      />
    </div>
  );
}

export default App;
