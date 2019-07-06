const autoprefixer = require('autoprefixer');

module.exports = {
    entry: ['./src/main/ui-src/sass/app.scss', './src/main/ui-src/js/app.js'],
    output: {
        // This is necessary for webpack to compile
        // But we never use style-bundle.js
        filename: 'src/main/resources/static/js/style-bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.scss$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            name: 'src/main/resources/static/css/bundle.css',
                        },
                    },
                    { loader: 'extract-loader' },
                    { loader: 'css-loader' },
                    {
                        loader: 'postcss-loader',
                        options: {
                            plugins: () => [autoprefixer()]
                        }
                    },
                    {
                        loader: 'sass-loader',
                        options: {
                            includePaths: ['./node_modules']
                        }
                    },
                ]
            }
        ]
    },
};