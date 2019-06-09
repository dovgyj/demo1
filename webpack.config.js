const path = require('path');

const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const OptimizeCSSAssetsPlugin = require('optimize-css-assets-webpack-plugin');
const TerserJSPlugin = require('terser-webpack-plugin');

module.exports = {
    watch:true,
    entry: './src/main/frontend/js/index.js',
    output: {
        filename: 'js/app.js',
        path: path.resolve(__dirname, 'src/main/webapp')
    },
    optimization: {
        minimizer: [ new OptimizeCSSAssetsPlugin({}), new TerserJSPlugin({})],
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },
            {
                test: /\.scss$/,
                use:  [  'style-loader', MiniCssExtractPlugin.loader, 'css-loader','sass-loader']
            }
        ],
    },
    plugins:[
        new MiniCssExtractPlugin({
            filename:"css/app.css",
        })
    ]
};

// module.exports = {
//     entry: './src/main/frontend/css/index.css',
//     output: {
//         filename: 'app.css',
//         path: path.resolve(__dirname, 'src/main/webapp/css')
//     },
//     module:{
//         rules:[
//             {
//                 test: /\.css$/,
//                 use: ['css-loader',"style-loader"]
//             }
//         ]
//     },
//     // plugins: [
//     //     new ExtractTextPlugin('app.css')
//     // ]
// };


