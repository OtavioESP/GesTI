import { ResponsivePie } from "@nivo/pie";

const PieChart = ({ data }) => (
  <ResponsivePie
    data={data}
    margin={{ top: 50, right: 100, bottom: 50, left: 60 }}
    innerRadius={0.35}
    padAngle={0.7}
    cornerRadius={3}
    activeOuterRadiusOffset={20}
    borderWidth={0}
    borderColor={{
      from: "color",
      modifiers: [["darker", 0.2]],
    }}
    enableArcLinkLabels={true}
    arcLinkLabel="value"
    arcLinkLabelsSkipAngle={2}
    arcLinkLabelsTextColor={{ from: "colors", modifiers: [] }}
    arcLinkLabelsThickness={2}
    arcLinkLabelsColor={{ from: "color" }}
    arcLabel="id"
    arcLabelsSkipAngle={10}
    arcLabelsTextColor={{
      from: "color",
      modifiers: [["darker", 2]],
    }}
    motionConfig="wobbly"
    theme={{
      text: {
        fontSize: 17,
        fill: "#333333",
        fontWeight: "bold",
        boxShadow: "black",
      },
    }}
    arcLinkLabelsOffset={2}
    // arcLabelsComponent={({ datum, label, style }) => (
    //   <g transform={style.transform} style={{ pointerEvents: "none" }}>
    //     <circle fill={style.textColor} cy={6} r={15} />
    //     <circle fill="#ffffff" stroke={datum.color} strokeWidth={2} r={16} />
    //     <text
    //       textAnchor="middle"
    //       dominantBaseline="central"
    //       fill={style.textColor}
    //       style={{ fontSize: 10, fontWeight: 800 }}
    //     >
    //       {label}
    //     </text>
    //   </g>
    // )}
    legends={[
      {
        anchor: "right",
        direction: "column",
        justify: false,
        translateX: 100,
        translateY: 0,
        itemsSpacing: 10,
        itemDirection: "left-to-right",
        itemWidth: 100,
        itemHeight: 18,
        itemTextColor: "#999",
        symbolSize: 18,
        symbolShape: "square",
        effects: [
          {
            on: "hover",
            style: {
              itemTextColor: "#000",
            },
          },
        ],
      },
    ]}
  />
);
export default PieChart;
