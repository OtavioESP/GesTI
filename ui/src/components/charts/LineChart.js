import { ResponsiveLine } from "@nivo/line";

const LineChart = ({ data, title }) => (
  <ResponsiveLine
    data={data}
    margin={{ top: 50, right: 110, bottom: 50, left: 60 }}
    xScale={{ type: "point" }}
    yScale={{
      type: "linear",
      min: "auto",
      max: "auto",
      stacked: true,
      reverse: false,
    }}
    yFormat=" >-.2f"
    axisTop={null}
    axisRight={null}
    axisBottom={{
      tickSize: 5,
      tickPadding: 5,
      tickRotation: 0,
      legend: title,
      legendOffset: 36,
      legendPosition: "middle",
      truncateTickAt: 0,
    }}
    axisLeft={{
      tickSize: 5,
      tickPadding: 5,
      tickRotation: 0,
      legend: "count",
      legendOffset: -40,
      legendPosition: "middle",
      truncateTickAt: 0,
    }}
    enableGridY={true}
    colors={{ scheme: "nivo" }}
    pointSize={7}
    pointColor={{ from: "color", modifiers: [] }}
    pointBorderWidth={2}
    pointBorderColor={{ from: "serieColor" }}
    pointLabel="data.y"
    pointLabelYOffset={-12}
    enableArea={true}
    areaOpacity={0.1}
    enableTouchCrosshair={true}
    useMesh={true}
    legends={[
      {
        anchor: "right",
        direction: "column",
        justify: false,
        translateX: 122,
        translateY: 0,
        itemWidth: 100,
        itemHeight: 20,
        itemsSpacing: 11,
        symbolSize: 14,
        symbolShape: "circle",
        itemDirection: "left-to-right",
        itemTextColor: "#777",
        effects: [
          {
            on: "hover",
            style: {
              itemBackground: "rgba(0, 0, 0, .03)",
              itemOpacity: 1,
            },
          },
        ],
      },
    ]}
  />
);
export default LineChart;
